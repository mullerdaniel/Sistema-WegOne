package Model;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrientacaoDAO_fr {

    public static void exibirOrientacoes_fr() {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoes_fr";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Titre: " + rs.getString("titre"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOrientacao_fr(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nTitre: ");
            final String titulo = scanner.nextLine();
            System.out.print("Type: ");
            String tipo = scanner.nextLine();
            System.out.print("Description: ");
            String descricao = scanner.nextLine();

            String sql = "INSERT INTO orientacoes_fr (titre, type, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);

            stmt.executeUpdate();

            System.out.println("\n¡Orientación insertada con éxito!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarOrientacao_fr(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID de la orientación para actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nouveau titre : ");
            String titulo = scanner.nextLine();
            System.out.print("Nouveau type : ");
            String tipo = scanner.nextLine();
            System.out.print("Nouvelle description : ");
            String descricao = scanner.nextLine();
            // Text conteudo_pt = scanner.nextLine();
            // System.out.print("Novo conteudo: ");

            String sql = "UPDATE orientacoes_fr SET titre = ?, type = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);
            stmt.setInt(4, id);
            int linhasAfetadas = stmt.executeUpdate();

            // logica para atualizar apenas um valor de conteudo e deixar os demais com seus
            // conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

            if (linhasAfetadas > 0)
                System.out.println("\n¡Actualización realizada con éxito!");
            else
                System.out.println("\nID non trouvé.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrientacao_fr(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID de la orientación para eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM orientacoes_fr WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0)
                System.out.println("\nOrientation supprimée avec succès !");
            else
                System.out.println("\nID non trouvé.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesquisarOrientacao_fr(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            // Étape 1 : Afficher les types uniques d’orientation
            Set<String> tiposUnicos = new HashSet<>(); // Set pour éviter les doublons

            // Requête pour récupérer tous les types
            String sqlTipos = "SELECT DISTINCT type FROM orientacoes_fr";
            Statement stmtTipos = conn.createStatement();
            ResultSet rsTipos = stmtTipos.executeQuery(sqlTipos);

            // Remplir l’ensemble avec les types uniques
            while (rsTipos.next()) {
                tiposUnicos.add(rsTipos.getString("type"));
            }

            // Afficher les types d’orientation disponibles
            System.out.println("\nTypes d’orientation disponibles...\n");
            for (String tipo : tiposUnicos) {
                System.out.println("📂 Type d’orientation : " + tipo);
            }

            // Étape 2 : Demander à l’utilisateur de rechercher un type
            System.out.print("\nRecherchez le type d’orientation : ");
            String nomeTipo = scanner.nextLine();

            // Vérifier si le type saisi existe
            boolean tipoEncontrado = false;
            for (String tipo : tiposUnicos) {
                if (nomeTipo.equals(tipo)) {
                    tipoEncontrado = true;
                    break;
                }
            }

            if (!tipoEncontrado) {
                System.out.println("\n❌ Type d’orientation introuvable !");
                return;
            }

            // Étape 3 : Afficher les titres du type trouvé
            System.out.println("\n══════════════════════════════════════════════════════════════════════════");
            System.out.println("Tous les titres pour le type d’orientation : " + nomeTipo);
            System.out.println("══════════════════════════════════════════════════════════════════════════\n");

            String sqlTitulos = "SELECT titre FROM orientacoes_fr WHERE type = ?";
            PreparedStatement stmtTitulos = conn.prepareStatement(sqlTitulos);
            stmtTitulos.setString(1, nomeTipo);
            ResultSet rsTitulos = stmtTitulos.executeQuery();

            boolean encontrouTitulos = false;
            while (rsTitulos.next()) {
                System.out.println("🔖 " + rsTitulos.getString("titre"));
                encontrouTitulos = true;
            }

            if (!encontrouTitulos) {
                System.out.println("\n❌ Aucun titre trouvé pour ce type !");
                return;
            }

            // Étape 4 : Demander à l’utilisateur de sélectionner un titre
            System.out.print("\nSélectionnez un titre d’orientation : ");
            String tituloSelecionado = scanner.nextLine();

            // Étape 5 : Afficher les détails de l’orientation sélectionnée
            String sqlDetalhes = "SELECT * FROM orientacoes_fr WHERE titre = ?";
            PreparedStatement stmtDetalhes = conn.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, tituloSelecionado);
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();

            boolean tituloEncontrado = false;
            while (rsDetalhes.next()) {
                if (tituloSelecionado.equals(rsDetalhes.getString("titre"))) {
                    tituloEncontrado = true;
                    System.out.println("\n----------------------------------------");
                    System.out.println("🔖 Titre de l’orientation : " + rsDetalhes.getString("trite"));
                    System.out.println("📂 Type d’orientation : " + rsDetalhes.getString("type"));
                    System.out.println("📝 Description : " + rsDetalhes.getString("description"));
                    System.out.println("----------------------------------------");
                    break;
                }
            }

            if (!tituloEncontrado) {
                System.out.println("\n❌ Titre introuvable ! Veuillez réessayer.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
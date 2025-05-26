package Model;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrientacaoDAO_en {

    public static void exibirOrientacoes_en() {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoes_en";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("description: " + rs.getString("description"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOrientacao_en(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nTitle: ");
            scanner.nextLine();
            String titulo = scanner.nextLine();
            System.out.print("Type: ");
            String tipo = scanner.nextLine();
            System.out.print("description: ");
            String descricao = scanner.nextLine();

            String sql = "INSERT INTO orientacoes_en (title, type, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);

            stmt.executeUpdate();

            System.out.println("\nGuidance inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarOrientacao_en(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID of the guidance to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("New Title: ");
            String titulo = scanner.nextLine();
            System.out.print("New Type: ");
            String tipo = scanner.nextLine();
            System.out.print("New Description: ");
            String descricao = scanner.nextLine();
            // Text conteudo_pt = scanner.nextLine();
            // System.out.print("Novo conteudo: ");

            String sql = "UPDATE orientacoes_en SET title = ?, type = ?, description = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);
            stmt.setInt(4, id);
            int linhasAfetadas = stmt.executeUpdate();

            // logica para atualizar apenas um valor de conteudo e deixar os demais com seus
            // conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

            if (linhasAfetadas > 0)
                System.out.println("\nUpdate completed successfully!");
            else
                System.out.println("\nID not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrientacao_en(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID of the guidance to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM orientacoes_en WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0)
                System.out.println("\nGuidance deleted successfully!");
            else
                System.out.println("\nID not found.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesquisarOrientacao_en(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            // Step 1: Display the unique types of orientations
            Set<String> tiposUnicos = new HashSet<>(); // Set to ensure types are not repeated

            // Query to fetch all distinct types
            String sqlTipos = "SELECT DISTINCT type FROM orientacoes_en";
            Statement stmtTipos = conn.createStatement();
            ResultSet rsTipos = stmtTipos.executeQuery(sqlTipos);

            // Fill the set with unique types
            while (rsTipos.next()) {
                tiposUnicos.add(rsTipos.getString("type"));
            }

            // Display available orientation types
            System.out.println("\nAvailable Orientation Types...\n");
            for (String tipo : tiposUnicos) {
                System.out.println("📂 Orientation Type: " + tipo);
            }

            // Step 2: Ask the user to search for a type
            System.out.print("\nSearch for the orientation type: ");
            String nomeTipo = scanner.nextLine();

            // Check if the entered type exists
            boolean tipoEncontrado = false;
            for (String tipo : tiposUnicos) {
                if (nomeTipo.equals(tipo)) {
                    tipoEncontrado = true;
                    break;
                }
            }

            if (!tipoEncontrado) {
                System.out.println("\n❌ Orientation type not found!");
                return; // Ends the search if the type is not found
            }

            // Step 3: Display the titles of the orientations for the found type
            System.out.println("\n══════════════════════════════════════════════════════════════════════════");
            System.out.println("All titles with the orientation type: " + nomeTipo);
            System.out.println("══════════════════════════════════════════════════════════════════════════\n");

            String sqlTitulos = "SELECT title FROM orientacoes_en WHERE type = ?";
            PreparedStatement stmtTitulos = conn.prepareStatement(sqlTitulos);
            stmtTitulos.setString(1, nomeTipo); // Exact search by type
            ResultSet rsTitulos = stmtTitulos.executeQuery();

            // Display the titles
            boolean encontrouTitulos = false;
            while (rsTitulos.next()) {
                System.out.println("🔖 " + rsTitulos.getString("title"));
                encontrouTitulos = true;
            }

            if (!encontrouTitulos) {
                System.out.println("\n❌ No titles found for this type!");
                return; // Ends if there are no titles for the type
            }

            // Step 4: Ask the user to select a title
            System.out.print("\nSelect an orientation title: ");
            String tituloSelecionado = scanner.nextLine();

            // Step 5: Display the details of the selected orientation
            String sqlDetalhes = "SELECT * FROM orientacoes_en WHERE title = ?";
            PreparedStatement stmtDetalhes = conn.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, tituloSelecionado); // Exact search by title
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();

            boolean tituloEncontrado = false;
            while (rsDetalhes.next()) {
                if (tituloSelecionado.equals(rsDetalhes.getString("title"))) {
                    tituloEncontrado = true;
                    System.out.println("\n----------------------------------------");
                    System.out.println("🔖 Orientation Title: " + rsDetalhes.getString("title"));
                    System.out.println("📂 Orientation Type: " + rsDetalhes.getString("type"));
                    System.out.println("📝 Description: " + rsDetalhes.getString("description"));
                    System.out.println("----------------------------------------");
                    break;
                }
            }

            if (!tituloEncontrado) {
                System.out.println("\n❌ Title not found! You may try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package Model;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrientacaoDAO_de {

    public static void exibirOrientacoes_de() {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoes_de";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Titel: " + rs.getString("titel"));
                System.out.println("Typ: " + rs.getString("typ"));
                System.out.println("Beschreibung: " + rs.getString("beschreibung"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOrientacao_de(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nTitel: ");
            scanner.nextLine();
            String titulo = scanner.nextLine();
            System.out.print("Typ: ");
            String tipo = scanner.nextLine();
            System.out.print("Beschreibung: ");
            String descricao = scanner.nextLine();

            String sql = "INSERT INTO orientacoes_de (titel, typ, beschreibung) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);

            stmt.executeUpdate();

            System.out.println("\nBetreuung erfolgreich hinzugefügt!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarOrientacao_de(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID der Betreuung zum Aktualisieren: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Neuer Titel: ");
            String titulo = scanner.nextLine();
            System.out.print("Neuer Typ: ");
            String tipo = scanner.nextLine();
            System.out.print("Neue Beschreibung: ");
            String descricao = scanner.nextLine();
            // Text conteudo_pt = scanner.nextLine();
            // System.out.print("Novo conteudo: ");

            String sql = "UPDATE orientacoes_de SET titel = ?, typ = ?, beschreibung = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);
            stmt.setInt(4, id);
            int linhasAfetadas = stmt.executeUpdate();

            // logica para atualizar apenas um valor de conteudo e deixar os demais com seus
            // conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

            if (linhasAfetadas > 0)
                System.out.println("\nAktualisierung erfolgreich durchgeführt!");
            else
                System.out.println("\nID nicht gefunden.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrientacao_de(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID der Betreuung zum Löschen: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM orientacoes_de WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0)
                System.out.println("\nBetreuung erfolgreich gelöscht!");
            else
                System.out.println("\nID nicht gefunden.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesquisarOrientacao_de(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            // Schritt 1: Einzigartige Orientierungstypen anzeigen
            Set<String> tiposUnicos = new HashSet<>(); // Set, um Wiederholungen zu vermeiden

            // Abfrage zur Auswahl aller Typen
            String sqlTipos = "SELECT DISTINCT typ FROM orientacoes_de";
            Statement stmtTipos = conn.createStatement();
            ResultSet rsTipos = stmtTipos.executeQuery(sqlTipos);

            // Füllen des Sets mit einzigartigen Typen
            while (rsTipos.next()) {
                tiposUnicos.add(rsTipos.getString("typ"));
            }

            // Anzeige verfügbarer Orientierungstypen
            System.out.println("\nVerfügbare Orientierungstypen...\n");
            for (String tipo : tiposUnicos) {
                System.out.println("📂 Orientierungstyp: " + tipo);
            }

            // Schritt 2: Benutzer auffordern, einen Typ zu suchen
            System.out.print("\nSuchen Sie nach dem Orientierungstyp: ");
            String nomeTipo = scanner.nextLine();

            // Überprüfen, ob der eingegebene Typ existiert
            boolean tipoEncontrado = false;
            for (String tipo : tiposUnicos) {
                if (nomeTipo.equals(tipo)) {
                    tipoEncontrado = true;
                    break;
                }
            }

            if (!tipoEncontrado) {
                System.out.println("\n❌ Orientierungstyp nicht gefunden!");
                return;
            }

            // Schritt 3: Titel für den gefundenen Typ anzeigen
            System.out.println("\n══════════════════════════════════════════════════════════════════════════");
            System.out.println("Alle Titel mit dem Orientierungstyp: " + nomeTipo);
            System.out.println("══════════════════════════════════════════════════════════════════════════\n");

            String sqlTitulos = "SELECT titel FROM orientacoes_de WHERE typ = ?";
            PreparedStatement stmtTitulos = conn.prepareStatement(sqlTitulos);
            stmtTitulos.setString(1, nomeTipo);
            ResultSet rsTitulos = stmtTitulos.executeQuery();

            boolean encontrouTitulos = false;
            while (rsTitulos.next()) {
                System.out.println("🔖 " + rsTitulos.getString("titel"));
                encontrouTitulos = true;
            }

            if (!encontrouTitulos) {
                System.out.println("\n❌ Keine Titel für diesen Typ gefunden!");
                return;
            }

            // Schritt 4: Benutzer auffordern, einen Titel auszuwählen
            System.out.print("\nWählen Sie einen Orientierungstitel: ");
            String tituloSelecionado = scanner.nextLine();

            // Schritt 5: Details zur ausgewählten Orientierung anzeigen
            String sqlDetalhes = "SELECT * FROM orientacoes_de WHERE titel = ?";
            PreparedStatement stmtDetalhes = conn.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, tituloSelecionado);
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();

            boolean tituloEncontrado = false;
            while (rsDetalhes.next()) {
                if (tituloSelecionado.equals(rsDetalhes.getString("titel"))) {
                    tituloEncontrado = true;
                    System.out.println("\n----------------------------------------");
                    System.out.println("🔖 Orientierungstitel: " + rsDetalhes.getString("titel"));
                    System.out.println("📂 Orientierungstyp: " + rsDetalhes.getString("typ"));
                    System.out.println("📝 Beschreibung: " + rsDetalhes.getString("Beschreibung"));
                    System.out.println("----------------------------------------");
                    break;
                }
            }

            if (!tituloEncontrado) {
                System.out.println("\n❌ Titel nicht gefunden! Versuchen Sie es erneut.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
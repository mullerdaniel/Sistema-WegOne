package Model;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrientacaoDAO_pt {

    public static void exibirOrientacoes_pt() {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoes_pt";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Descricao: " + rs.getString("Descricao"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOrientacao_pt(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nTítulo: ");
            scanner.nextLine();
            String titulo = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("descricao: ");
            String descricao = scanner.nextLine();

            String sql = "INSERT INTO orientacoes_pt (titulo, tipo, descricao) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);

            stmt.executeUpdate();

            System.out.println("\nOrientação inserida com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editarOrientacao_pt(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID da orientação para atualizar: ");
            int id = scanner.nextInt();
            System.out.print("Novo título: ");
            String titulo = scanner.nextLine();
            scanner.nextInt();
            System.out.print("Novo tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Nova Descrição: ");
            String descricao = scanner.nextLine();
            // Text conteudo_pt = scanner.nextLine();
            // System.out.print("Novo conteudo: ");

            String sql = "UPDATE orientacoes_pt SET titulo = ?, tipo = ?, descricao = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, tipo);
            stmt.setString(3, descricao);
            stmt.setInt(4, id);
            int linhasAfetadas = stmt.executeUpdate();

            // logica para atualizar apenas um valor de conteudo e deixar os demais com seus
            // conteudos antigos - atualmente a lógica atualiza apenas 3 colunas

            if (linhasAfetadas > 0)
                System.out.println("\nAtualização realizada com sucesso!");
            else
                System.out.println("\nID não encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrientacao_pt(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID da orientação para deletar: ");
            int id = scanner.nextInt();

            String sql = "DELETE FROM orientacoes_pt WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0)
                System.out.println("\nOrientação excluída com sucesso!");
            else
                System.out.println("\nID não encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesquisarOrientacao_pt(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            // Passo 1: Exibir os tipos únicos de orientações
            Set<String> tiposUnicos = new HashSet<>(); // Set para garantir que os tipos não se repitam

            // Consulta para buscar todos os tipos
            String sqlTipos = "SELECT DISTINCT tipo FROM orientacoes_pt";
            Statement stmtTipos = conn.createStatement();
            ResultSet rsTipos = stmtTipos.executeQuery(sqlTipos);

            // Preenche o conjunto com os tipos únicos
            while (rsTipos.next()) {
                tiposUnicos.add(rsTipos.getString("tipo"));
            }

            // Exibe os tipos de orientação disponíveis
            System.out.println("\nTipos de Orientações disponíveis...\n");
            for (String tipo : tiposUnicos) {
                System.out.println("📂 Tipo da Orientação: " + tipo);
            }

            // Passo 2: Solicitar ao usuário para pesquisar um tipo
            scanner.nextLine();
            System.out.print("\nPesquise o tipo da orientação: ");
            String nomeTipo = scanner.nextLine();

            // Verificar se o tipo informado existe
            boolean tipoEncontrado = false;
            for (String tipo : tiposUnicos) {
                if (nomeTipo.equals(tipo)) {
                    tipoEncontrado = true;
                    break;

                }
            }

            if (!tipoEncontrado) {
                System.out.println("\n❌ Tipo de orientação não encontrado!");
                return; // Finaliza a busca se o tipo não for encontrado
            }

            // Passo 3: Exibir os títulos das orientações para o tipo encontrado
            System.out.println("\n══════════════════════════════════════════════════════════════════════════");
            System.out.println("Todos os títulos com o tipo de orientação: " + nomeTipo);
            System.out.println("══════════════════════════════════════════════════════════════════════════\n");

            String sqlTitulos = "SELECT titulo FROM orientacoes_pt WHERE tipo = ?";
            PreparedStatement stmtTitulos = conn.prepareStatement(sqlTitulos);
            stmtTitulos.setString(1, nomeTipo); // Pesquisa exata pelo tipo
            ResultSet rsTitulos = stmtTitulos.executeQuery();

            // Exibe os títulos
            boolean encontrouTitulos = false;
            while (rsTitulos.next()) {
                System.out.println("🔖 " + rsTitulos.getString("titulo"));
                encontrouTitulos = true;
            }

            if (!encontrouTitulos) {
                System.out.println("\n❌ Nenhum título encontrado para esse tipo!");
                return; // Finaliza se não houver títulos para o tipo
            }

            // Passo 4: Solicitar ao usuário selecionar um título
            System.out.print("\nSelecione um título da orientação: ");
            String tituloSelecionado = scanner.nextLine();

            // Passo 5: Exibir os detalhes da orientação selecionada
            String sqlDetalhes = "SELECT * FROM orientacoes_pt WHERE titulo = ?";
            PreparedStatement stmtDetalhes = conn.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, tituloSelecionado); // Pesquisa exata pelo título
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();

            boolean tituloEncontrado = false;
            while (rsDetalhes.next()) {
                if (tituloSelecionado.equals(rsDetalhes.getString("titulo"))) {
                    tituloEncontrado = true;
                    System.out.println("\n----------------------------------------");
                    System.out.println("🔖 Título da Orientação: " + rsDetalhes.getString("titulo"));
                    System.out.println("📂 Tipo da Orientação: " + rsDetalhes.getString("tipo"));
                    System.out.println("📝 Descrição: " + rsDetalhes.getString("descricao"));
                    System.out.println("----------------------------------------");
                    break;
                }
            }

            if (!tituloEncontrado) {
                System.out.println("\n❌ Título não encontrado! Você pode tentar novamente.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
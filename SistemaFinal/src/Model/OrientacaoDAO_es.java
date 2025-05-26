package Model;

import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class OrientacaoDAO_es {

    public static void exibirOrientacoes_es() {
        try (Connection conn = Conexao.getConexao()) {
            String sql = "SELECT * FROM orientacoes_es";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("\nID: " + rs.getInt("id"));
                System.out.println("Titulo: " + rs.getString("titulo"));
                System.out.println("Tipo: " + rs.getString("tipo"));
                System.out.println("Descripcion: " + rs.getString("descripcion"));
                System.out.println("------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cadastrarOrientacao_es(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nTítulo: ");
            String titulo = scanner.nextLine();
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Descripcion: ");
            String descricao = scanner.nextLine();

            String sql = "INSERT INTO orientacoes_es (titulo, tipo, descripcion) VALUES (?, ?, ?)";
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

    public static void editarOrientacao_es(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID de la orientación para actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo titulo: ");
            String titulo = scanner.nextLine();
            System.out.print("Novo tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Nova descripcion: ");
            String descricao = scanner.nextLine();
            // Text conteudo_pt = scanner.nextLine();
            // System.out.print("Novo conteudo: ");

            String sql = "UPDATE orientacoes_es SET titulo = ?, tipo = ?, descripcion = ? WHERE id = ?";
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
                System.out.println("\nID no encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void excluirOrientacao_es(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            System.out.print("\nID de la orientación para eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            String sql = "DELETE FROM orientacoes_es WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0)
                System.out.println("\n¡Orientación eliminada con éxito!");
            else
                System.out.println("\nID no encontrado.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void pesquisarOrientacao_es(Scanner scanner) {
        try (Connection conn = Conexao.getConexao()) {
            // Paso 1: Mostrar tipos únicos de orientación
            Set<String> tiposUnicos = new HashSet<>(); // Conjunto para evitar repeticiones

            // Consulta para obtener todos los tipos
            String sqlTipos = "SELECT DISTINCT tipo FROM orientacoes_es";
            Statement stmtTipos = conn.createStatement();
            ResultSet rsTipos = stmtTipos.executeQuery(sqlTipos);

            // Llenar el conjunto con tipos únicos
            while (rsTipos.next()) {
                tiposUnicos.add(rsTipos.getString("tipo"));
            }

            // Mostrar los tipos de orientación disponibles
            System.out.println("\nTipos de orientación disponibles...\n");
            for (String tipo : tiposUnicos) {
                System.out.println("📂 Tipo de orientación: " + tipo);
            }

            // Paso 2: Solicitar al usuario buscar un tipo
            System.out.print("\nBuscar el tipo de orientación: ");
            String nomeTipo = scanner.nextLine();

            // Verificar si el tipo existe
            boolean tipoEncontrado = false;
            for (String tipo : tiposUnicos) {
                if (nomeTipo.equals(tipo)) {
                    tipoEncontrado = true;
                    break;
                }
            }

            if (!tipoEncontrado) {
                System.out.println("\n❌ ¡Tipo de orientación no encontrado!");
                return;
            }

            // Paso 3: Mostrar títulos del tipo encontrado
            System.out.println("\n══════════════════════════════════════════════════════════════════════════");
            System.out.println("Todos los títulos con el tipo de orientación: " + nomeTipo);
            System.out.println("══════════════════════════════════════════════════════════════════════════\n");

            String sqlTitulos = "SELECT titulo FROM orientacoes_es WHERE tipo = ?";
            PreparedStatement stmtTitulos = conn.prepareStatement(sqlTitulos);
            stmtTitulos.setString(1, nomeTipo);
            ResultSet rsTitulos = stmtTitulos.executeQuery();

            boolean encontrouTitulos = false;
            while (rsTitulos.next()) {
                System.out.println("🔖 " + rsTitulos.getString("titulo"));
                encontrouTitulos = true;
            }

            if (!encontrouTitulos) {
                System.out.println("\n❌ ¡No se encontraron títulos para este tipo!");
                return;
            }

            // Paso 4: Solicitar al usuario seleccionar un título
            System.out.print("\nSeleccione un título de la orientación: ");
            String tituloSelecionado = scanner.nextLine();

            // Paso 5: Mostrar los detalles del título seleccionado
            String sqlDetalhes = "SELECT * FROM orientacoes_es WHERE titulo = ?";
            PreparedStatement stmtDetalhes = conn.prepareStatement(sqlDetalhes);
            stmtDetalhes.setString(1, tituloSelecionado);
            ResultSet rsDetalhes = stmtDetalhes.executeQuery();

            boolean tituloEncontrado = false;
            while (rsDetalhes.next()) {
                if (tituloSelecionado.equals(rsDetalhes.getString("titulo"))) {
                    tituloEncontrado = true;
                    System.out.println("\n----------------------------------------");
                    System.out.println("🔖 Título de la orientación: " + rsDetalhes.getString("titulo"));
                    System.out.println("📂 Tipo de orientación: " + rsDetalhes.getString("tipo"));
                    System.out.println("📝 Descripción: " + rsDetalhes.getString("descripcion"));
                    System.out.println("----------------------------------------");
                    break;
                }
            }

            if (!tituloEncontrado) {
                System.out.println("\n❌ ¡Título no encontrado! Intenta de nuevo.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
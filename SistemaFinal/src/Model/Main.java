package Model;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variaveis
        int opcao;
        int idioma;
        int c = 0;

        do {
            System.out.println("\n════════════════════════════════════════");
            System.out.println("       🌍 Escolha o idioma do sistema           ");
            System.out.println("════════════════════════════════════════");
            System.out.println("  1 - Português");
            System.out.println("  2 - Inglês");
            System.out.println("  3 - Alemão");
            System.out.println("  4 - Espanhol");
            System.out.println("  5 - Francês");
            System.out.println("════════════════════════════════════════");
            System.out.print("Digite sua opção: ");
            idioma = sc.nextInt();

            // Caso digite um numero indisponivel o sistema retornara o menu
            if (idioma >= 1 && idioma <= 5) {
                c++;
            }

        } while (c == 0);

        // Seleção em Português
        if (idioma == 1) { // Português

            do {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("          📋 MENU PRINCIPAL           ");
                System.out.println("════════════════════════════════════════");
                System.out.println("  1 - 📝 Cadastrar");
                System.out.println("  2 - 🔍 Pesquisar");
                System.out.println("  3 - ✏️ Editar");
                System.out.println("  4 - ❌ Excluir");
                System.out.println("  5 - 📊 Exibir");
                System.out.println("  6 - 🚪 Sair");
                System.out.println("════════════════════════════════════════");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt(); // Usando 'sc' aqui

                switch (opcao) {
                    case 1:
                        OrientacaoDAO_pt.cadastrarOrientacao_pt(sc); // Método em portugues
                        break;
                    case 2:
                        OrientacaoDAO_pt.pesquisarOrientacao_pt(sc); // Método em portugues
                        break;
                    case 3:
                        OrientacaoDAO_pt.editarOrientacao_pt(sc); // Método em portugues
                        break;
                    case 4:
                        OrientacaoDAO_pt.excluirOrientacao_pt(sc); // Método em portugues
                        break;
                    case 5:
                        OrientacaoDAO_pt.exibirOrientacoes_pt(); // Método em portugues
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 6); // O loop continua até o usuário escolher a opção 0

            // Seleção em Inglês
        } else if (idioma == 2) {
            do {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("          📋 MAIN MENU           ");
                System.out.println("════════════════════════════════════════");
                System.out.println("  1 - 📝 Register");
                System.out.println("  2 - 🔍 Search");
                System.out.println("  3 - ✏️ Edit");
                System.out.println("  4 - ❌ Delete");
                System.out.println("  5 - 📊 Display");
                System.out.println("  6 - 🚪 Exit");
                System.out.println("════════════════════════════════════════");
                System.out.print("Choose an option: ");
                opcao = sc.nextInt(); // Using 'sc' here
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        OrientacaoDAO_en.cadastrarOrientacao_en(sc); // Método em inglês
                        break;
                    case 2:
                        OrientacaoDAO_en.pesquisarOrientacao_en(sc); // Método em inglês
                        break;
                    case 3:
                        OrientacaoDAO_en.editarOrientacao_en(sc); // Método em inglês
                        break;
                    case 4:
                        OrientacaoDAO_en.excluirOrientacao_en(sc); // Método em inglês
                        break;
                    case 5:
                        OrientacaoDAO_en.exibirOrientacoes_en(); // Método em inglês
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            } while (opcao != 6); // O loop continua até o usuário escolher a opção 0

            // Seleção em Alemão
        } else if (idioma == 3) {

            do {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("          📋 HAUPTMENÜ           ");
                System.out.println("════════════════════════════════════════");
                System.out.println("  1 - 📝 Registrieren");
                System.out.println("  2 - 🔍 Suchen");
                System.out.println("  3 - ✏️ Bearbeiten");
                System.out.println("  4 - ❌ Löschen");
                System.out.println("  5 - 📊 Anzeigen");
                System.out.println("  6 - 🚪 Beenden");
                System.out.println("════════════════════════════════════════");
                System.out.print("Wähle eine Option: ");
                opcao = sc.nextInt(); // Lendo a opção do usuário
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        OrientacaoDAO_de.cadastrarOrientacao_de(sc); // Método em alemão
                        break;
                    case 2:
                        OrientacaoDAO_de.pesquisarOrientacao_de(sc); // Método em alemão
                        break;
                    case 3:
                        OrientacaoDAO_de.editarOrientacao_de(sc); // Método em alemão
                        break;
                    case 4:
                        OrientacaoDAO_de.excluirOrientacao_de(sc); // Método em alemão
                        break;
                    case 5:
                        OrientacaoDAO_de.exibirOrientacoes_de(); // Método em alemão
                        break;
                    case 6:
                        System.out.println("Beende das Programm..."); // Saindo do sistema
                        break;
                    default:
                        System.out.println("Ungültige Option!"); // Opção inválida
                }
            } while (opcao != 6); // O loop continua até o usuário escolher a opção 6

            // Seleção em Espanhol
        } else if (idioma == 4) {

            do {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("          📋 MENÚ PRINCIPAL           ");
                System.out.println("════════════════════════════════════════");
                System.out.println("  1 - 📝 Registrar");
                System.out.println("  2 - 🔍 Buscar");
                System.out.println("  3 - ✏️ Editar");
                System.out.println("  4 - ❌ Eliminar");
                System.out.println("  5 - 📊 Mostrar");
                System.out.println("  6 - 🚪 Salir");
                System.out.println("════════════════════════════════════════");
                System.out.print("Elige una opción: ");
                opcao = sc.nextInt(); // Lendo a opção do usuário
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        OrientacaoDAO_es.cadastrarOrientacao_es(sc); // Método em espanhol
                        break;
                    case 2:
                        OrientacaoDAO_es.pesquisarOrientacao_es(sc); // Método em espanhol
                        break;
                    case 3:
                        OrientacaoDAO_es.editarOrientacao_es(sc); // Método em espanhol
                        break;
                    case 4:
                        OrientacaoDAO_es.excluirOrientacao_es(sc); // Método em espanhol
                        break;
                    case 5:
                        OrientacaoDAO_es.exibirOrientacoes_es(); // Método em espanhol
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema..."); // Saindo do sistema
                        break;
                    default:
                        System.out.println("¡Opción inválida!"); // Opção inválida
                }
            } while (opcao != 6); // O loop continua até o usuário escolher a opção 6

            // Seleção em Frances
        } else if (idioma == 5) {

            do {
                System.out.println("\n════════════════════════════════════════");
                System.out.println("          📋 MENU PRINCIPAL           ");
                System.out.println("════════════════════════════════════════");
                System.out.println("  1 - 📝 Enregistrer");
                System.out.println("  2 - 🔍 Rechercher");
                System.out.println("  3 - ✏️ Modifier");
                System.out.println("  4 - ❌ Supprimer");
                System.out.println("  5 - 📊 Afficher");
                System.out.println("  6 - 🚪 Quitter");
                System.out.println("════════════════════════════════════════");
                System.out.print("Choisissez une option : ");
                opcao = sc.nextInt(); // Lendo a opção do usuário
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        OrientacaoDAO_fr.cadastrarOrientacao_fr(sc); // Método em francês
                        break;
                    case 2:
                        OrientacaoDAO_fr.pesquisarOrientacao_fr(sc); // Método em francês
                        break;
                    case 3:
                        OrientacaoDAO_fr.editarOrientacao_fr(sc); // Método em francês
                        break;
                    case 4:
                        OrientacaoDAO_fr.excluirOrientacao_fr(sc); // Método em francês
                        break;
                    case 5:
                        OrientacaoDAO_fr.exibirOrientacoes_fr(); // Método em francês
                        break;
                    case 6:
                        System.out.println("Fermeture du programme..."); // Saindo do sistema
                        break;
                    default:
                        System.out.println("Option invalide !"); // Opção inválida
                }
            } while (opcao != 6); // O loop continua até o usuário escolher a opção 6

        }

        sc.close(); // Fechar o scanner após o uso
    }
}

// System.out.println("Idioma não reconhecido!");

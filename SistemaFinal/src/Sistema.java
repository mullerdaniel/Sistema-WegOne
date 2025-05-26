import java.util.Scanner;
import java.text.Normalizer; // Esse é para normalizar o texto podendo ter ou não letras maiusculas e minusculas ou com assento ou sem assento
import java.util.HashSet; // Esse que é uma implementação concreta da interface Set.
import java.util.Set; // Esse é a interface Set, que define a estrutura de dados para um conjunto de elementos únicos.

public class Sistema {

    public static String normalizar(String texto) { // Função para normalizar texto
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .toLowerCase();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // VARIAVEIS
        int menu;
        int idioma;
        int i = 10;
        int c = 0;
        String atualizarOrientacao;

        // ARRAY
        String tituloDaOrientacao[] = new String[11];
        String tipoDaOrientacao[] = new String[11];
        String descricaoDaOrientacao[] = new String[11];

        // Selecionar Idioma
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
            idioma = input.nextInt();

            // Caso digite um numero indisponivel o sistema retornara o menu
            if (idioma >= 1 && idioma <= 5) {
                c++;
            }

        } while (c == 0);

        // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

        // SISTEMA EM PORTUGUÊS:
        if (idioma == 1) {

            // Dados Cadastrados No Sistema
            tituloDaOrientacao[0] = "Manual de Operação de Motores";
            tipoDaOrientacao[0] = "Manual de Operação";
            descricaoDaOrientacao[0] = "Orientações detalhadas sobre o uso correto e eficiente dos equipamentos.";

            tituloDaOrientacao[1] = "Procedimento de Segurança para Instalação Elétrica";
            tipoDaOrientacao[1] = "Procedimento de Segurança";
            descricaoDaOrientacao[1] = "Orientações sobre como realizar manutenção e reparos nos equipamentos.";

            tituloDaOrientacao[2] = "Manutenção de Motores Elétricos";
            tipoDaOrientacao[2] = "Manutenção e Reparos";
            descricaoDaOrientacao[2] = "Procedimentos para realizar testes de operação e diagnóstico de falhas nos equipamentos.";

            tituloDaOrientacao[3] = "Teste de Diagnóstico de Transformadores";
            tipoDaOrientacao[3] = "Testes e Diagnóstico";
            descricaoDaOrientacao[3] = "Procedimentos para realizar testes de operação e diagnóstico de falhas nos equipamentos.";

            tituloDaOrientacao[4] = "Manual de Conduta no Setor de Montagem";
            tipoDaOrientacao[4] = "Manual de Conduta e Operações Setoriais";
            descricaoDaOrientacao[4] = "Orientações sobre como os colaboradores devem agir em determinados setores da empresa, com foco em boas práticas e processos específicos de cada área.";

            tituloDaOrientacao[5] = "Procedimento de Segurança com Risco de Choque Elétrico";
            tipoDaOrientacao[5] = "Procedimento de Segurança";
            descricaoDaOrientacao[5] = "Orientações sobre como realizar manutenção e reparos nos equipamentos.";

            tituloDaOrientacao[6] = "Manutenção de Geradores de Energia";
            tipoDaOrientacao[6] = "Manutenção e Reparos";
            descricaoDaOrientacao[6] = "Procedimentos para realizar testes de operação e diagnóstico de falhas nos equipamentos.";

            tituloDaOrientacao[7] = "Teste de Funcionamento de Equipamentos de Automação";
            tipoDaOrientacao[7] = "Testes e Diagnóstico";
            descricaoDaOrientacao[7] = "Procedimentos para realizar testes de operação e diagnóstico de falhas nos equipamentos.";

            tituloDaOrientacao[8] = "Manual de Operação de Equipamentos de Soldagem";
            tipoDaOrientacao[8] = "Manual de Operação";
            descricaoDaOrientacao[8] = "Orientações detalhadas sobre o uso correto e eficiente dos equipamentos.";

            tituloDaOrientacao[9] = "Procedimento de Segurança no Setor de Montagem";
            tipoDaOrientacao[9] = "Procedimento de Segurança";
            descricaoDaOrientacao[9] = "Orientações sobre como realizar manutenção e reparos nos equipamentos.";

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

            // MENU
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
                System.out.print("Selecione uma opção: ");
                menu = input.nextInt();
                input.nextLine();

                // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                // 1 CADASTRAR
                if (menu == 1) {
                    if (i >= tituloDaOrientacao.length) {

                        String[] novoTitulo = new String[tituloDaOrientacao.length + 1];
                        String[] novoTipo = new String[tipoDaOrientacao.length + 1];
                        String[] novaDescricao = new String[descricaoDaOrientacao.length + 1];

                        for (int j = 0; j < tituloDaOrientacao.length; j++) {
                            novoTitulo[j] = tituloDaOrientacao[j];
                            novoTipo[j] = tipoDaOrientacao[j];
                            novaDescricao[j] = descricaoDaOrientacao[j];
                        }

                        tituloDaOrientacao = novoTitulo;
                        tipoDaOrientacao = novoTipo;
                        descricaoDaOrientacao = novaDescricao;
                    }

                    System.out.println("\n\nEscreva o título da orientação: ");
                    tituloDaOrientacao[i] = input.nextLine();
                    System.out.println(
                            "\nEscreva o Tipo da orientação: [Manual de Operação, Procedimento de Segurança, Manutenção e Reparos, Testes e Diagnóstico ou Manual de Conduta e Operações Setoriais]: 	");
                    tipoDaOrientacao[i] = input.nextLine();
                    System.out.println("\nEscreva a descrição da orientação: ");
                    descricaoDaOrientacao[i] = input.nextLine();
                    i++; // Incrementa o índice após adicionar

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 2 PESQUISAR
                } else if (menu == 2) {

                    Set<String> tiposUnicos = new HashSet<>(); // Set para que os tipos não se repitam

                    for (int d = 0; d < i; d++) {
                        tiposUnicos.add(tipoDaOrientacao[d]);
                    }

                    // Exibe os tipos de orientação únicos
                    System.out.println("\nTipos de Orientações disponíveis...\n");
                    for (String tipo : tiposUnicos) {
                        System.out.println("📂 Tipo da Orientação: " + tipo);
                    }

                    System.out.println("\n\nPesquise o tipo da orientação: ");
                    String nomeTipo = input.nextLine();

                    boolean encontrado = false;
                    for (int j = 0; j < i; j++) {
                        if (normalizar(nomeTipo).equals(normalizar(tipoDaOrientacao[j]))) {
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("\n❌ Tipo de orientação não encontrado!");
                        continue;
                    }

                    System.out.println("\n══════════════════════════════════════════════════════════════════════════");
                    System.out.println("Todos os títulos com o tipo de orientação: " + nomeTipo);
                    System.out.println("══════════════════════════════════════════════════════════════════════════\n");

                    // Exibe os títulos dos itens do tipo selecionado
                    for (int n = 0; n < i; n++) {
                        if (normalizar(tipoDaOrientacao[n]).equals(normalizar(nomeTipo))) {
                            System.out.println("🔖 " + tituloDaOrientacao[n]);
                        }
                    }

                    System.out.println("\n\nSelecione um título da orientação: ");
                    String tituloSelecionado = input.nextLine();
                    boolean tituloEncontrado = false;

                    // Exibe o título, tipo e descrição do item selecionado
                    for (int l = 0; l < i; l++) {
                        if (normalizar(tituloSelecionado).equals(normalizar(tituloDaOrientacao[l]))) {
                            tituloEncontrado = true;

                            // Exibe o título, tipo e descrição do item selecionado
                            System.out.println("\n----------------------------------------");
                            System.out.println("🔖 Título da Orientação: " + tituloDaOrientacao[l]);
                            System.out.println("📂 Tipo da Orientação: " + tipoDaOrientacao[l]);
                            System.out.println("📝 Descrição: " + descricaoDaOrientacao[l]);
                            System.out.println("----------------------------------------");

                            break;
                        }
                    }

                    if (!tituloEncontrado) {
                        System.out.println("\n❌ Título não encontrado! Você pode tentar novamente.");
                        continue;
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 3 EDITAR
                } else if (menu == 3) {
                    // Set para que os tipos não se repitam
                    Set<String> tiposUnicos1 = new HashSet<>();

                    for (int z = 0; z < i; z++) {
                        tiposUnicos1.add(tipoDaOrientacao[z]);
                    }

                    // Exibe os tipos de orientação únicos para edição
                    System.out.println("\nTipos de Orientações disponíveis para edição...\n");
                    for (String tipo : tiposUnicos1) {
                        System.out.println("📂 Tipo da Orientação: " + tipo);
                    }

                    System.out.println("\nEscreva o tipo de orientação que você deseja mudar: ");
                    atualizarOrientacao = input.nextLine();

                    String tipoAtualNormalizado = normalizar(atualizarOrientacao);
                    boolean tipoEncontrado = false;

                    // Buscar o tipo de orientação que será editado
                    for (int h = 0; h < i; h++) {
                        if (normalizar(tipoDaOrientacao[h]).equals(tipoAtualNormalizado)) {
                            tipoEncontrado = true;
                            System.out.println(
                                    "\n\nTipo de Orientação selecionada: " + tipoDaOrientacao[h] + "\n\nNovo Tipo: ");
                            atualizarOrientacao = input.nextLine();
                            tipoDaOrientacao[h] = atualizarOrientacao;
                            break;
                        }
                    }

                    if (!tipoEncontrado) {
                        System.out.println("\n❌ Tipo de orientação não encontrado para editar!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 4 REMOVER
                } else if (menu == 4) {
                    String produtoRemovido;

                    System.out.println("\n\nItens disponíveis: \n");
                    for (int p = 0; p < i; p++) {
                        System.out.println("📚 " + tituloDaOrientacao[p]);
                    }
                    System.out.println("\nDigite o item que você deseja remover: ");
                    produtoRemovido = input.nextLine();

                    String nomeProdutoNormalizado = normalizar(produtoRemovido);
                    boolean removido = false;

                    for (int k = 0; k < i; k++) {
                        if (normalizar(tituloDaOrientacao[k]).equals(nomeProdutoNormalizado)) {
                            for (int j = k; j < i - 1; j++) {
                                tituloDaOrientacao[j] = tituloDaOrientacao[j + 1];
                                tipoDaOrientacao[j] = tipoDaOrientacao[j + 1];
                            }
                            tituloDaOrientacao[i - 1] = null;
                            tipoDaOrientacao[i - 1] = null;
                            i--;
                            removido = true;
                            break;
                        }
                    }

                    if (removido) {
                        System.out.println("\nItem removido com sucesso!");
                        System.out.println("\n\nItens após remoção:\n");
                        for (int p = 0; p < i; p++) {
                            if (tituloDaOrientacao[p] != null) {
                                System.out.println("📂 " + tituloDaOrientacao[p]);
                            }
                        }
                    } else {
                        System.out.println("Item " + produtoRemovido + " não encontrado para remover!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 5 EXIBIR
                } else if (menu == 5) {

                    System.out.println("\n\n════════════════════════════════════════");
                    System.out.println("     📚 ORIENTAÇÕES CADASTRADAS         ");
                    System.out.println("════════════════════════════════════════");

                    for (int d = 0; d < i; d++) {
                        System.out.println("\n🔖 Título da Orientação: " + tituloDaOrientacao[d]);
                        System.out.println("📂 Tipo da Orientação: " + tipoDaOrientacao[d]);

                        // Aqui ele vai Verificar se a descrição personalizada foi cadastrada
                        String descricaoExibida = descricaoDaOrientacao[d] != null
                                && !descricaoDaOrientacao[d].isEmpty()
                                        ? descricaoDaOrientacao[d] // Exibindo a descrição personalizada
                                        : ""; // Se não tiver descrição personalizada, vai ficar em branco

                        // Adicionar a descrição padrão se não houver uma descrição personalizada
                        if (descricaoExibida.isEmpty()) {
                            switch (tipoDaOrientacao[d].toLowerCase()) {
                                case "manual de operação":
                                    descricaoExibida = "Orientações detalhadas sobre o uso correto e eficiente dos equipamentos. \n📝 Exemplos: Manual de operação de motores, transformadores, geradores, etc.";
                                    break;
                                case "procedimento de segurança":
                                    descricaoExibida = "Procedimentos detalhados para garantir a segurança durante a operação de equipamentos e instalações elétricas. \n📝 Exemplos: Procedimento de segurança para instalação elétrica, risco de choque elétrico, etc.";
                                    break;
                                case "manutenção e reparos":
                                    descricaoExibida = "Orientações para a manutenção e reparos de equipamentos, sistemas e dispositivos. \n📝 Exemplos: Manutenção de motores elétricos, geradores de energia, etc.";
                                    break;
                                case "testes e diagnóstico":
                                    descricaoExibida = "Procedimentos para testar e diagnosticar problemas em equipamentos e sistemas. \n📝 Exemplos: Teste de diagnóstico de transformadores, automação, etc.";
                                    break;
                                case "manual de conduta e operações setoriais":
                                    descricaoExibida = "Normas e orientações para a conduta dentro de setores específicos e suas operações. \n📝 Exemplos: Manual de conduta no setor de montagem, etc.";
                                    break;
                                default:
                                    descricaoExibida = "Descrição padrão não disponível.";
                            }
                        }

                        // Exibir a descrição
                        System.out.println("📝 Descrição: " + descricaoExibida);
                        System.out.println("\n----------------------------------------");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 6 SAIR
                } else if (menu == 6) {
                    System.out.print("\nSaindo");

                    for (int s = 0; s < 3; s++) { // Vai adicionar 3 pontos no total
                        try {
                            Thread.sleep(1000); // Pausa de 1 segundos
                            System.out.print("."); // Adiciona um ponto
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(); // Pula linha após a mensagem
                    break; // Sai do loop e encerra o programa
                }
            } while (menu != 6);

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

            // SYSTEM IN ENGLISH:

        
        } if (idioma == 2) {

            // Data Registered in the System
            tituloDaOrientacao[0] = "Motor Operation Manual";
            tipoDaOrientacao[0] = "Operation Manual";
            descricaoDaOrientacao[0] = "Detailed guidance on correct and efficient equipment usage.";
            tituloDaOrientacao[1] = "Electrical Installation Safety Procedure";
            tipoDaOrientacao[1] = "Safety Procedure";
            descricaoDaOrientacao[1] = "Guidance on how to perform equipment maintenance and repairs.";
            tituloDaOrientacao[2] = "Electric Motor Maintenance";
            tipoDaOrientacao[2] = "Maintenance and Repairs";
            descricaoDaOrientacao[2] = "Procedures for performing operation tests and equipment failure diagnosis.";
            tituloDaOrientacao[3] = "Transformer Diagnostic Testing";
            tipoDaOrientacao[3] = "Testing and Diagnosis";
            descricaoDaOrientacao[3] = "Procedures for performing operation tests and equipment failure diagnosis.";
            tituloDaOrientacao[4] = "Assembly Sector Conduct Manual";
            tipoDaOrientacao[4] = "Sector Conduct and Operations Manual";
            descricaoDaOrientacao[4] = "Guidance on how employees should behave in specific company sectors, focusing on best practices and area-specific processes.";
            tituloDaOrientacao[5] = "Electrical Shock Risk Safety Procedure";
            tipoDaOrientacao[5] = "Safety Procedure";
            descricaoDaOrientacao[5] = "Guidance on how to perform equipment maintenance and repairs.";
            tituloDaOrientacao[6] = "Power Generator Maintenance";
            tipoDaOrientacao[6] = "Maintenance and Repairs";
            descricaoDaOrientacao[6] = "Procedures for performing operation tests and equipment failure diagnosis.";
            tituloDaOrientacao[7] = "Automation Equipment Functionality Testing";
            tipoDaOrientacao[7] = "Testing and Diagnosis";
            descricaoDaOrientacao[7] = "Procedures for performing operation tests and equipment failure diagnosis.";
            tituloDaOrientacao[8] = "Welding Equipment Operation Manual";
            tipoDaOrientacao[8] = "Operation Manual";
            descricaoDaOrientacao[8] = "Detailed guidance on correct and efficient equipment usage.";
            tituloDaOrientacao[9] = "Assembly Sector Safety Procedure";
            tipoDaOrientacao[9] = "Safety Procedure";
            descricaoDaOrientacao[9] = "Guidance on how to perform equipment maintenance and repairs.";

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

            // MENU
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
                System.out.print("Select an option: ");
                menu = input.nextInt();
                input.nextLine();

                // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                // 1 REGISTER
                if (menu == 1) {
                    if (i >= tituloDaOrientacao.length) {
                        String[] novoTitulo = new String[tituloDaOrientacao.length + 1];
                        String[] novoTipo = new String[tipoDaOrientacao.length + 1];
                        String[] novaDescricao = new String[descricaoDaOrientacao.length + 1];
                        for (int j = 0; j < tituloDaOrientacao.length; j++) {
                            novoTitulo[j] = tituloDaOrientacao[j];
                            novoTipo[j] = tipoDaOrientacao[j];
                            novaDescricao[j] = descricaoDaOrientacao[j];
                        }

                        tituloDaOrientacao = novoTitulo;
                        tipoDaOrientacao = novoTipo;
                        descricaoDaOrientacao = novaDescricao;
                    }

                    System.out.println("\n\nEnter the guidance title: ");
                    tituloDaOrientacao[i] = input.nextLine();
                    System.out.println(
                            "\nEnter the guidance type: [Operation Manual, Safety Procedure, Maintenance and Repairs, Testing and Diagnosis or Sector Conduct and Operations Manual]: 	");
                    tipoDaOrientacao[i] = input.nextLine();
                    System.out.println("\nEnter the guidance description: ");
                    descricaoDaOrientacao[i] = input.nextLine();
                    i++; // Increment index after adding

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 2 SEARCH
                } else if (menu == 2) {

                    Set<String> tiposUnicos = new HashSet<>(); // Set to avoid repeating types
                    for (int d = 0; d < i; d++) {
                        tiposUnicos.add(tipoDaOrientacao[d]);
                    }
                    // Display unique guidance types
                    System.out.println("\nAvailable guidance types...\n");
                    for (String tipo : tiposUnicos) {
                        System.out.println("📂 Guidance Type: " + tipo);
                    }
                    System.out.println("\n\nSearch for a guidance type: ");
                    String nomeTipo = input.nextLine();
                    boolean encontrado = false;
                    for (int j = 0; j < i; j++) {
                        if (normalizar(nomeTipo).equals(normalizar(tipoDaOrientacao[j]))) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n❌ Guidance type not found!");
                        continue;
                    }
                    System.out.println("\n══════════════════════════════════════════════════════════════════════════");
                    System.out.println("All titles with guidance type: " + nomeTipo);
                    System.out.println("══════════════════════════════════════════════════════════════════════════\n");
                    // Display titles of items of selected type
                    for (int n = 0; n < i; n++) {
                        if (normalizar(tipoDaOrientacao[n]).equals(normalizar(nomeTipo))) {
                            System.out.println("🔖 " + tituloDaOrientacao[n]);
                        }
                    }
                    System.out.println("\n\nSelect a guidance title: ");
                    String tituloSelecionado = input.nextLine();
                    boolean tituloEncontrado = false;
                    // Display title, type and description of selected item
                    for (int l = 0; l < i; l++) {
                        if (normalizar(tituloSelecionado).equals(normalizar(tituloDaOrientacao[l]))) {
                            tituloEncontrado = true;
                            // Display title, type and description of selected item
                            System.out.println("\n----------------------------------------");
                            System.out.println("🔖 Guidance Title: " + tituloDaOrientacao[l]);
                            System.out.println("📂 Guidance Type: " + tipoDaOrientacao[l]);
                            System.out.println("📝 Description: " + descricaoDaOrientacao[l]);
                            System.out.println("----------------------------------------");
                            break;
                        }
                    }
                    if (!tituloEncontrado) {
                        System.out.println("\n❌ Title not found! You can try again.");
                        continue;
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 3 EDIT
                } else if (menu == 3) {
                    // Set to avoid repeating types
                    Set<String> tiposUnicos1 = new HashSet<>();
                    for (int z = 0; z < i; z++) {
                        tiposUnicos1.add(tipoDaOrientacao[z]);
                    }
                    // Display unique guidance types for editing
                    System.out.println("\nAvailable guidance types for editing...\n");
                    for (String tipo : tiposUnicos1) {
                        System.out.println("📂 Guidance Type: " + tipo);
                    }
                    System.out.println("\nEnter the guidance type you want to change: ");
                    atualizarOrientacao = input.nextLine();
                    String tipoAtualNormalizado = normalizar(atualizarOrientacao);
                    boolean tipoEncontrado = false;
                    // Search for guidance type to be edited
                    for (int h = 0; h < i; h++) {
                        if (normalizar(tipoDaOrientacao[h]).equals(tipoAtualNormalizado)) {
                            tipoEncontrado = true;
                            System.out.println("\n\nSelected Guidance Type: " + tipoDaOrientacao[h] + "\n\nNew Type: ");
                            atualizarOrientacao = input.nextLine();
                            tipoDaOrientacao[h] = atualizarOrientacao;
                            break;
                        }
                    }
                    if (!tipoEncontrado) {
                        System.out.println("\n❌ Guidance type not found for editing!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 4 DELETE
                } else if (menu == 4) {
                    String produtoRemovido;
                    System.out.println("\n\nAvailable items: \n");
                    for (int p = 0; p < i; p++) {
                        System.out.println("📚 " + tituloDaOrientacao[p]);
                    }
                    System.out.println("\nEnter the item you want to remove: ");
                    produtoRemovido = input.nextLine();
                    String nomeProdutoNormalizado = normalizar(produtoRemovido);
                    boolean removido = false;
                    for (int k = 0; k < i; k++) {
                        if (normalizar(tituloDaOrientacao[k]).equals(nomeProdutoNormalizado)) {
                            for (int j = k; j < i - 1; j++) {
                                tituloDaOrientacao[j] = tituloDaOrientacao[j + 1];
                                tipoDaOrientacao[j] = tipoDaOrientacao[j + 1];
                            }
                            tituloDaOrientacao[i - 1] = null;
                            tipoDaOrientacao[i - 1] = null;
                            i--;
                            removido = true;
                            break;
                        }
                    }
                    if (removido) {
                        System.out.println("\nItem removed successfully!");
                        System.out.println("\n\nItems after removal:\n");
                        for (int p = 0; p < i; p++) {
                            if (tituloDaOrientacao[p] != null) {
                                System.out.println("📂 " + tituloDaOrientacao[p]);
                            }
                        }
                    } else {
                        System.out.println("Item " + produtoRemovido + " not found for removal!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 5 DISPLAY
                } else if (menu == 5) {

                    System.out.println("\n\n════════════════════════════════════════");
                    System.out.println("     📚 REGISTERED GUIDANCE         ");
                    System.out.println("════════════════════════════════════════");
                    for (int d = 0; d < i; d++) {
                        System.out.println("\n🔖 Guidance Title: " + tituloDaOrientacao[d]);
                        System.out.println("📂 Guidance Type: " + tipoDaOrientacao[d]);
                        // Check if custom description was registered
                        String descricaoExibida = descricaoDaOrientacao[d] != null
                                && !descricaoDaOrientacao[d].isEmpty()
                                        ? descricaoDaOrientacao[d] // Display custom description
                                        : ""; // If no custom description, leave blank
                        // Add default description if no custom description exists
                        if (descricaoExibida.isEmpty()) {
                            switch (tipoDaOrientacao[d].toLowerCase()) {
                                case "operation manual":
                                    descricaoExibida = "Detailed guidance on correct and efficient equipment usage. \n📝 Examples: Motor operation manual, transformers, generators, etc.";
                                    break;
                                case "safety procedure":
                                    descricaoExibida = "Detailed procedures to ensure safety during equipment operation and electrical installations. \n📝 Examples: Safety procedure for electrical installation, electrical shock risk, etc.";
                                    break;
                                case "maintenance and repairs":
                                    descricaoExibida = "Guidance for equipment, systems and devices maintenance and repairs. \n📝 Examples: Electric motor maintenance, power generators, etc.";
                                    break;
                                case "testing and diagnosis":
                                    descricaoExibida = "Procedures for testing and diagnosing equipment and system problems. \n📝 Examples: Transformer diagnostic testing, automation, etc.";
                                    break;
                                case "sector conduct and operations manual":
                                    descricaoExibida = "Rules and guidance for conduct within specific sectors and their operations. \n📝 Examples: Assembly sector conduct manual, etc.";
                                    break;
                                default:
                                    descricaoExibida = "Default description not available.";
                            }
                        }
                        // Display description
                        System.out.println("📝 Description: " + descricaoExibida);
                        System.out.println("\n----------------------------------------");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

                    // 6 EXIT
                } else if (menu == 6) {
                    System.out.print("\nExiting");

                    for (int s = 0; s < 3; s++) { // Will add 3 dots total
                        try {
                            Thread.sleep(1000); // 1 second pause
                            System.out.print("."); // Add a dot
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(); // New line after message
                    break; // Exit loop and end program
                }
            } while (menu != 6);

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

            // SYSTEM AUF DEUTSCH:
        
        } if (idioma == 3) {
            // Registrierte Systemdaten
            tituloDaOrientacao[0] = "Betriebsanleitung für Motoren";
            tipoDaOrientacao[0] = "Betriebsanleitung";
            descricaoDaOrientacao[0] = "Detaillierte Anleitungen zur korrekten und effizienten Nutzung der Geräte.";
            tituloDaOrientacao[1] = "Sicherheitsverfahren für Elektroinstallation";
            tipoDaOrientacao[1] = "Sicherheitsverfahren";
            descricaoDaOrientacao[1] = "Anleitungen zur Wartung und Reparatur von Geräten.";
            tituloDaOrientacao[2] = "Wartung von Elektromotoren";
            tipoDaOrientacao[2] = "Wartung und Reparaturen";
            descricaoDaOrientacao[2] = "Verfahren zur Durchführung von Betriebstests und Fehlerdiagnose bei Geräten.";
            tituloDaOrientacao[3] = "Diagnosetest für Transformatoren";
            tipoDaOrientacao[3] = "Tests und Diagnose";
            descricaoDaOrientacao[3] = "Verfahren zur Durchführung von Betriebstests und Fehlerdiagnose bei Geräten.";
            tituloDaOrientacao[4] = "Verhaltensrichtlinie im Montagebereich";
            tipoDaOrientacao[4] = "Verhaltens- und Bereichsrichtlinie";
            descricaoDaOrientacao[4] = "Anleitungen zum Verhalten der Mitarbeiter in bestimmten Unternehmensbereichen mit Fokus auf Best Practices und bereichsspezifische Prozesse.";
            tituloDaOrientacao[5] = "Sicherheitsverfahren bei Stromschlaggefahr";
            tipoDaOrientacao[5] = "Sicherheitsverfahren";
            descricaoDaOrientacao[5] = "Anleitungen zur Wartung und Reparatur von Geräten.";
            tituloDaOrientacao[6] = "Wartung von Stromgeneratoren";
            tipoDaOrientacao[6] = "Wartung und Reparaturen";
            descricaoDaOrientacao[6] = "Verfahren zur Durchführung von Betriebstests und Fehlerdiagnose bei Geräten.";
            tituloDaOrientacao[7] = "Funktionstest für Automatisierungsgeräte";
            tipoDaOrientacao[7] = "Tests und Diagnose";
            descricaoDaOrientacao[7] = "Verfahren zur Durchführung von Betriebstests und Fehlerdiagnose bei Geräten.";
            tituloDaOrientacao[8] = "Betriebsanleitung für Schweißgeräte";
            tipoDaOrientacao[8] = "Betriebsanleitung";
            descricaoDaOrientacao[8] = "Detaillierte Anleitungen zur korrekten und effizienten Nutzung der Geräte.";
            tituloDaOrientacao[9] = "Sicherheitsverfahren im Montagebereich";
            tipoDaOrientacao[9] = "Sicherheitsverfahren";
            descricaoDaOrientacao[9] = "Anleitungen zur Wartung und Reparatur von Geräten.";
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // MENÜ
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
                System.out.print("Wählen Sie eine Option: ");
                menu = input.nextInt();
                input.nextLine();
                // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                // 1 REGISTRIEREN
                if (menu == 1) {
                    if (i >= tituloDaOrientacao.length) {
                        String[] novoTitulo = new String[tituloDaOrientacao.length + 1];
                        String[] novoTipo = new String[tipoDaOrientacao.length + 1];
                        String[] novaDescricao = new String[descricaoDaOrientacao.length + 1];
                        for (int j = 0; j < tituloDaOrientacao.length; j++) {
                            novoTitulo[j] = tituloDaOrientacao[j];
                            novoTipo[j] = tipoDaOrientacao[j];
                            novaDescricao[j] = descricaoDaOrientacao[j];
                        }
                        tituloDaOrientacao = novoTitulo;
                        tipoDaOrientacao = novoTipo;
                        descricaoDaOrientacao = novaDescricao;
                    }
                    System.out.println("\n\nGeben Sie den Titel der Anleitung ein: ");
                    tituloDaOrientacao[i] = input.nextLine();
                    System.out.println(
                            "\nGeben Sie den Typ der Anleitung ein: [Betriebsanleitung, Sicherheitsverfahren, Wartung und Reparaturen, Tests und Diagnose oder Verhaltens- und Bereichsrichtlinie]: 	");
                    tipoDaOrientacao[i] = input.nextLine();
                    System.out.println("\nGeben Sie die Beschreibung der Anleitung ein: ");
                    descricaoDaOrientacao[i] = input.nextLine();
                    i++; // Index nach Hinzufügen erhöhen
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 2 SUCHEN
                } else if (menu == 2) {

                    Set<String> tiposUnicos = new HashSet<>(); // Set damit Typen nicht wiederholt werden
                    for (int d = 0; d < i; d++) {
                        tiposUnicos.add(tipoDaOrientacao[d]);
                    }
                    // Zeigt einzigartige Anleitungstypen an
                    System.out.println("\nVerfügbare Anleitungstypen...\n");
                    for (String tipo : tiposUnicos) {
                        System.out.println("📂 Anleitungstyp: " + tipo);
                    }
                    System.out.println("\n\nSuchen Sie nach einem Anleitungstyp: ");
                    String nomeTipo = input.nextLine();
                    boolean encontrado = false;
                    for (int j = 0; j < i; j++) {
                        if (normalizar(nomeTipo).equals(normalizar(tipoDaOrientacao[j]))) {
                        	encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n❌ Anleitungstyp nicht gefunden!");
                        continue;
                    }
                    System.out.println("\n══════════════════════════════════════════════════════════════════════════");
                    System.out.println("Alle Titel mit dem Anleitungstyp: " + nomeTipo);
                    System.out.println("══════════════════════════════════════════════════════════════════════════\n");
                    // Zeigt Titel der ausgewählten Typen an
                    for (int n = 0; n < i; n++) {
                        if (normalizar(tipoDaOrientacao[n]).equals(normalizar(nomeTipo))) {
                            System.out.println("🔖 " + tituloDaOrientacao[n]);
                        }
                    }
                    System.out.println("\n\nWählen Sie einen Anleitungstitel: ");
                    String tituloSelecionado = input.nextLine();
                    boolean tituloEncontrado = false;
                    // Zeigt Titel, Typ und Beschreibung des ausgewählten Elements an
                    for (int l = 0; l < i; l++) {
                        if (normalizar(tituloSelecionado).equals(normalizar(tituloDaOrientacao[l]))) {
                            tituloEncontrado = true;
                            // Zeigt Titel, Typ und Beschreibung des ausgewählten Elements an
                            System.out.println("\n----------------------------------------");
                            System.out.println("🔖 Anleitungstitel: " + tituloDaOrientacao[l]);
                            System.out.println("📂 Anleitungstyp: " + tipoDaOrientacao[l]);
                            System.out.println("📝 Beschreibung: " + descricaoDaOrientacao[l]);
                            System.out.println("----------------------------------------");
                            break;
                        }
                    }
                    if (!tituloEncontrado) {
                        System.out.println("\n❌ Titel nicht gefunden! Sie können es erneut versuchen.");
                        continue;
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 3 BEARBEITEN
                } else if (menu == 3) {
                    // Set damit Typen nicht wiederholt werden
                    Set<String> tiposUnicos1 = new HashSet<>();
                    for (int z = 0; z < i; z++) {
                        tiposUnicos1.add(tipoDaOrientacao[z]);
                    }
                    // Zeigt einzigartige Anleitungstypen zur Bearbeitung an
                    System.out.println("\nVerfügbare Anleitungstypen zur Bearbeitung...\n");
                    for (String tipo : tiposUnicos1) {
                        System.out.println("📂 Anleitungstyp: " + tipo);
                    }
                    System.out.println("\nGeben Sie den Anleitungstyp ein, den Sie ändern möchten: ");
                    atualizarOrientacao = input.nextLine();
                    String tipoAtualNormalizado = normalizar(atualizarOrientacao);
                    boolean tipoEncontrado = false;
                    // Sucht nach dem zu bearbeitenden Anleitungstyp
                    for (int h = 0; h < i; h++) {
                        if (normalizar(tipoDaOrientacao[h]).equals(tipoAtualNormalizado)) {
                            tipoEncontrado = true;
                            System.out.println(
                                    "\n\nAusgewählter Anleitungstyp: " + tipoDaOrientacao[h] + "\n\nNeuer Typ: ");
                            atualizarOrientacao = input.nextLine();
                            tipoDaOrientacao[h] = atualizarOrientacao;
                            break;
                        }
                    }
                    if (!tipoEncontrado) {
                        System.out.println("\n❌ Anleitungstyp zum Bearbeiten nicht gefunden!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 4 LÖSCHEN
                } else if (menu == 4) {
                    String produtoRemovido;
                    System.out.println("\n\nVerfügbare Elemente: \n");
                    for (int p = 0; p < i; p++) {
                        System.out.println("📚 " + tituloDaOrientacao[p]);
                    }
                    System.out.println("\nGeben Sie das zu löschende Element ein: ");
                    produtoRemovido = input.nextLine();
                    String nomeProdutoNormalizado = normalizar(produtoRemovido);
                    boolean removido = false;
                    for (int k = 0; k < i; k++) {
                        if (normalizar(tituloDaOrientacao[k]).equals(nomeProdutoNormalizado)) {
                            for (int j = k; j < i - 1; j++) {
                                tituloDaOrientacao[j] = tituloDaOrientacao[j + 1];
                                tipoDaOrientacao[j] = tipoDaOrientacao[j + 1];
                            }
                            tituloDaOrientacao[i - 1] = null;
                            tipoDaOrientacao[i - 1] = null;
                            i--;
                            removido = true;
                            break;
                        }
                    }
                    if (removido) {
                        System.out.println("\nElement erfolgreich gelöscht!");
                        System.out.println("\n\nElemente nach Löschung:\n");
                        for (int p = 0; p < i; p++) {
                            if (tituloDaOrientacao[p] != null) {
                                System.out.println("📂 " + tituloDaOrientacao[p]);
                            }
                        }
                    } else {
                        System.out.println("Element " + produtoRemovido + " nicht zum Löschen gefunden!");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 5 ANZEIGEN
                } else if (menu == 5) {

                    System.out.println("\n\n════════════════════════════════════════");
                    System.out.println("     📚 REGISTRIERTE ANLEITUNGEN         ");
                    System.out.println("════════════════════════════════════════");
                    for (int d = 0; d < i; d++) {
                        System.out.println("\n🔖 Anleitungstitel: " + tituloDaOrientacao[d]);
                        System.out.println("📂 Anleitungstyp: " + tipoDaOrientacao[d]);
                        // Überprüft ob eine benutzerdefinierte Beschreibung registriert wurde
                        String descricaoExibida = descricaoDaOrientacao[d] != null
                                && !descricaoDaOrientacao[d].isEmpty()
                                        ? descricaoDaOrientacao[d] // Zeigt benutzerdefinierte Beschreibung
                                        : ""; // Wenn keine benutzerdefinierte Beschreibung, bleibt leer
                        // Fügt Standardbeschreibung hinzu, wenn keine benutzerdefinierte vorhanden ist
                        if (descricaoExibida.isEmpty()) {
                            switch (tipoDaOrientacao[d].toLowerCase()) {
                                case "betriebsanleitung":
                                    descricaoExibida = "Detaillierte Anleitungen zur korrekten und effizienten Nutzung der Geräte. \n📝 Beispiele: Betriebsanleitung für Motoren, Transformatoren, Generatoren usw.";
                                    break;
                                case "sicherheitsverfahren":
                                    descricaoExibida = "Detaillierte Verfahren zur Gewährleistung der Sicherheit beim Betrieb von Geräten und elektrischen Anlagen. \n📝 Beispiele: Sicherheitsverfahren für Elektroinstallation, Stromschlaggefahr usw.";
                                    break;
                                case "wartung und reparaturen":
                                    descricaoExibida = "Anleitungen für Wartung und Reparaturen von Geräten, Systemen und Vorrichtungen. \n📝 Beispiele: Wartung von Elektromotoren, Stromgeneratoren usw.";
                                    break;
                                case "tests und diagnose":
                                    descricaoExibida = "Verfahren zum Testen und Diagnostizieren von Problemen bei Geräten und Systemen. \n📝 Beispiele: Diagnosetest für Transformatoren, Automatisierung usw.";
                                    break;
                                case "verhaltens- und bereichsrichtlinie":
                                    descricaoExibida = "Richtlinien und Anleitungen für das Verhalten in bestimmten Bereichen und deren Betrieb. \n📝 Beispiele: Verhaltensrichtlinie im Montagebereich usw.";
                                    break;
                                default:
                                    descricaoExibida = "Standardbeschreibung nicht verfügbar.";
                            }
                        }
                        // Zeigt Beschreibung an
                        System.out.println("📝 Beschreibung: " + descricaoExibida);
                        System.out.println("\n----------------------------------------");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 6 BEENDEN
                } else if (menu == 6) {
                    System.out.print("\nBeenden");

                    for (int s = 0; s < 3; s++) { // Fügt insgesamt 3 Punkte hinzu
                        try {
                            Thread.sleep(1000); // Pause von 1 Sekunde
                            System.out.print("."); // Fügt einen Punkt hinzu
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(); // Neue Zeile nach der Nachricht
                    break; // Beendet Schleife und Programm
                }
            } while (menu != 6);
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

            // SISTEMA EN ESPAÑOL:
        
        } if (idioma == 4) {
            // Datos Registrados en el Sistema
            tituloDaOrientacao[0] = "Manual de Operación de Motores";
            tipoDaOrientacao[0] = "Manual de Operación";
            descricaoDaOrientacao[0] = "Instrucciones detalladas sobre el uso correcto y eficiente de los equipos.";
            tituloDaOrientacao[1] = "Procedimiento de Seguridad para Instalación Eléctrica";
            tipoDaOrientacao[1] = "Procedimiento de Seguridad";
            descricaoDaOrientacao[1] = "Instrucciones sobre cómo realizar mantenimiento y reparaciones en los equipos.";
            tituloDaOrientacao[2] = "Mantenimiento de Motores Eléctricos";
            tipoDaOrientacao[2] = "Mantenimiento y Reparaciones";
            descricaoDaOrientacao[2] = "Procedimientos para realizar pruebas de operación y diagnóstico de fallas en los equipos.";
            tituloDaOrientacao[3] = "Prueba de Diagnóstico de Transformadores";
            tipoDaOrientacao[3] = "Pruebas y Diagnóstico";
            descricaoDaOrientacao[3] = "Procedimientos para realizar pruebas de operación y diagnóstico de fallas en los equipos.";
            tituloDaOrientacao[4] = "Manual de Conducta en el Sector de Montaje";
            tipoDaOrientacao[4] = "Manual de Conducta y Operaciones Sectoriales";
            descricaoDaOrientacao[4] = "Instrucciones sobre cómo deben actuar los colaboradores en determinados sectores de la empresa, con enfoque en buenas prácticas y procesos específicos de cada área.";
            tituloDaOrientacao[5] = "Procedimiento de Seguridad con Riesgo de Descarga Eléctrica";
            tipoDaOrientacao[5] = "Procedimiento de Seguridad";
            descricaoDaOrientacao[5] = "Instrucciones sobre cómo realizar mantenimiento y reparaciones en los equipos.";
            tituloDaOrientacao[6] = "Mantenimiento de Generadores de Energía";
            tipoDaOrientacao[6] = "Mantenimiento y Reparaciones";
            descricaoDaOrientacao[6] = "Procedimientos para realizar pruebas de operación y diagnóstico de fallas en los equipos.";
            tituloDaOrientacao[7] = "Prueba de Funcionamiento de Equipos de Automatización";
            tipoDaOrientacao[7] = "Pruebas y Diagnóstico";
            descricaoDaOrientacao[7] = "Procedimientos para realizar pruebas de operación y diagnóstico de fallas en los equipos.";
            tituloDaOrientacao[8] = "Manual de Operación de Equipos de Soldadura";
            tipoDaOrientacao[8] = "Manual de Operación";
            descricaoDaOrientacao[8] = "Instrucciones detalladas sobre el uso correcto y eficiente de los equipos.";
            tituloDaOrientacao[9] = "Procedimiento de Seguridad en el Sector de Montaje";
            tipoDaOrientacao[9] = "Procedimiento de Seguridad";
            descricaoDaOrientacao[9] = "Instrucciones sobre cómo realizar mantenimiento y reparaciones en los equipos.";
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // MENÚ
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
                System.out.print("Seleccione una opción: ");
                menu = input.nextInt();
                input.nextLine();
                // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                // 1 REGISTRAR
                if (menu == 1) {
                    if (i >= tituloDaOrientacao.length) {
                        String[] novoTitulo = new String[tituloDaOrientacao.length + 1];
                        String[] novoTipo = new String[tipoDaOrientacao.length + 1];
                        String[] novaDescricao = new String[descricaoDaOrientacao.length + 1];
                        for (int j = 0; j < tituloDaOrientacao.length; j++) {
                            novoTitulo[j] = tituloDaOrientacao[j];
                            novoTipo[j] = tipoDaOrientacao[j];
                            novaDescricao[j] = descricaoDaOrientacao[j];
                        }
                        tituloDaOrientacao = novoTitulo;
                        tipoDaOrientacao = novoTipo;
                        descricaoDaOrientacao = novaDescricao;
                    }
                    System.out.println("\n\nEscriba el título de la orientación: ");
                    tituloDaOrientacao[i] = input.nextLine();
                    System.out.println(
                            "\nEscriba el Tipo de orientación: [Manual de Operación, Procedimiento de Seguridad, Mantenimiento y Reparaciones, Pruebas y Diagnóstico o Manual de Conducta y Operaciones Sectoriales]: 	");
                    tipoDaOrientacao[i] = input.nextLine();
                    System.out.println("\nEscriba la descripción de la orientación: ");
                    descricaoDaOrientacao[i] = input.nextLine();
                    i++; // Incrementa el índice después de agregar
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 2 BUSCAR
                } else if (menu == 2) {

                    Set<String> tiposUnicos = new HashSet<>(); // Set para que los tipos no se repitan
                    for (int d = 0; d < i; d++) {
                        tiposUnicos.add(tipoDaOrientacao[d]);
                    }
                    // Muestra los tipos de orientación únicos
                    System.out.println("\nTipos de Orientaciones disponibles...\n");
                    for (String tipo : tiposUnicos) {
                        System.out.println("📂 Tipo de Orientación: " + tipo);
                    }
                    System.out.println("\n\nBusque el tipo de orientación: ");
                    String nomeTipo = input.nextLine();
                    boolean encontrado = false;
                    for (int j = 0; j < i; j++) {
                        if (normalizar(nomeTipo).equals(normalizar(tipoDaOrientacao[j]))) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n❌ Tipo de orientación no encontrado!");
                        continue;
                    }
                    System.out.println("\n══════════════════════════════════════════════════════════════════════════");
                    System.out.println("Todos los títulos con el tipo de orientación: " + nomeTipo);
                    System.out.println("══════════════════════════════════════════════════════════════════════════\n");
                    // Muestra los títulos de los items del tipo seleccionado
                    for (int n = 0; n < i; n++) {
                        if (normalizar(tipoDaOrientacao[n]).equals(normalizar(nomeTipo))) {
                            System.out.println("🔖 " + tituloDaOrientacao[n]);
                        }
                    }
                    System.out.println("\n\nSeleccione un título de la orientación: ");
                    String tituloSelecionado = input.nextLine();
                    boolean tituloEncontrado = false;
                    // Muestra el título, tipo y descripción del item seleccionado
                    for (int l = 0; l < i; l++) {
                        if (normalizar(tituloSelecionado).equals(normalizar(tituloDaOrientacao[l]))) {
                            tituloEncontrado = true;
                            // Muestra el título, tipo y descripción del item seleccionado
                            System.out.println("\n----------------------------------------");
                            System.out.println("🔖 Título de Orientación: " + tituloDaOrientacao[l]);
                            System.out.println("📂 Tipo de Orientación: " + tipoDaOrientacao[l]);
                            System.out.println("📝 Descripción: " + descricaoDaOrientacao[l]);
                            System.out.println("----------------------------------------");
                            break;
                        }
                    }
                    if (!tituloEncontrado) {
                        System.out.println("\n❌ Título no encontrado! Puede intentar nuevamente.");
                        continue;
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 3 EDITAR
                } else if (menu == 3) {
                    // Set para que los tipos no se repitan
                    Set<String> tiposUnicos1 = new HashSet<>();
                    for (int z = 0; z < i; z++) {
                        tiposUnicos1.add(tipoDaOrientacao[z]);
                    }
                    // Muestra los tipos de orientación únicos para edición
                    System.out.println("\nTipos de Orientaciones disponibles para edición...\n");
                    for (String tipo : tiposUnicos1) {
                        System.out.println("📂 Tipo de Orientación: " + tipo);
                    }
                    System.out.println("\nEscriba el tipo de orientación que desea cambiar: ");
                    atualizarOrientacao = input.nextLine();
                    String tipoAtualNormalizado = normalizar(atualizarOrientacao);
                    boolean tipoEncontrado = false;
                    // Buscar el tipo de orientación que será editado
                    for (int h = 0; h < i; h++) {
                        if (normalizar(tipoDaOrientacao[h]).equals(tipoAtualNormalizado)) {
                            tipoEncontrado = true;
                            System.out.println("\n\nTipo de Orientación seleccionada: " + tipoDaOrientacao[h]
                                    + "\n\nNuevo Tipo: ");
                            atualizarOrientacao = input.nextLine();
                            tipoDaOrientacao[h] = atualizarOrientacao;
                            break;
                        }
                    }
                    if (!tipoEncontrado) {
                        System.out.println("\n❌ Tipo de orientación no encontrado para editar!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 4 ELIMINAR
                } else if (menu == 4) {
                    String produtoRemovido;
                    System.out.println("\n\nItems disponibles: \n");
                    for (int p = 0; p < i; p++) {
                        System.out.println("📚 " + tituloDaOrientacao[p]);
                    }
                    System.out.println("\nEscriba el item que desea eliminar: ");
                    produtoRemovido = input.nextLine();
                    String nomeProdutoNormalizado = normalizar(produtoRemovido);
                    boolean removido = false;
                    for (int k = 0; k < i; k++) {
                        if (normalizar(tituloDaOrientacao[k]).equals(nomeProdutoNormalizado)) {
                            for (int j = k; j < i - 1; j++) {
                                tituloDaOrientacao[j] = tituloDaOrientacao[j + 1];
                                tipoDaOrientacao[j] = tipoDaOrientacao[j + 1];
                            }
                            tituloDaOrientacao[i - 1] = null;
                            tipoDaOrientacao[i - 1] = null;
                            i--;
                            removido = true;
                            break;
                        }
                    }
                    if (removido) {
                        System.out.println("\nItem eliminado con éxito!");
                        System.out.println("\n\nItems después de eliminar:\n");
                        for (int p = 0; p < i; p++) {
                            if (tituloDaOrientacao[p] != null) {
                                System.out.println("📂 " + tituloDaOrientacao[p]);
                            }
                        }
                    } else {
                        System.out.println("Item " + produtoRemovido + " no encontrado para eliminar!");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 5 MOSTRAR
                } else if (menu == 5) {

                    System.out.println("\n\n════════════════════════════════════════");
                    System.out.println("     📚 ORIENTACIONES REGISTRADAS         ");
                    System.out.println("════════════════════════════════════════");
                    for (int d = 0; d < i; d++) {
                        System.out.println("\n🔖 Título de Orientación: " + tituloDaOrientacao[d]);
                        System.out.println("📂 Tipo de Orientación: " + tipoDaOrientacao[d]);
                        // Verifica si la descripción personalizada fue registrada
                        String descricaoExibida = descricaoDaOrientacao[d] != null
                                && !descricaoDaOrientacao[d].isEmpty()
                                        ? descricaoDaOrientacao[d] // Muestra la descripción personalizada
                                        : ""; // Si no tiene descripción personalizada, queda en blanco
                        // Agrega la descripción estándar si no hay una descripción personalizada
                        if (descricaoExibida.isEmpty()) {
                            switch (tipoDaOrientacao[d].toLowerCase()) {
                                case "manual de operación":
                                    descricaoExibida = "Instrucciones detalladas sobre el uso correcto y eficiente de los equipos. \n📝 Ejemplos: Manual de operación de motores, transformadores, generadores, etc.";
                                    break;
                                case "procedimiento de seguridad":
                                    descricaoExibida = "Procedimientos detallados para garantizar la seguridad durante la operación de equipos e instalaciones eléctricas. \n📝 Ejemplos: Procedimiento de seguridad para instalación eléctrica, riesgo de descarga eléctrica, etc.";
                                    break;
                                case "mantenimiento y reparaciones":
                                    descricaoExibida = "Instrucciones para el mantenimiento y reparaciones de equipos, sistemas y dispositivos. \n📝 Ejemplos: Mantenimiento de motores eléctricos, generadores de energía, etc.";
                                    break;
                                case "pruebas y diagnóstico":
                                    descricaoExibida = "Procedimientos para probar y diagnosticar problemas en equipos y sistemas. \n📝 Ejemplos: Prueba de diagnóstico de transformadores, automatización, etc.";
                                    break;
                                case "manual de conducta y operaciones sectoriales":
                                    descricaoExibida = "Normas e instrucciones para la conducta dentro de sectores específicos y sus operaciones. \n📝 Ejemplos: Manual de conducta en el sector de montaje, etc.";
                                    break;
                                default:
                                    descricaoExibida = "Descripción estándar no disponible.";
                            }
                        }
                        // Muestra la descripción
                        System.out.println("📝 Descripción: " + descricaoExibida);
                        System.out.println("\n----------------------------------------");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 6 SALIR
                } else if (menu == 6) {
                    System.out.print("\nSaliendo");

                    for (int s = 0; s < 3; s++) { // Añadirá 3 puntos en total
                        try {
                            Thread.sleep(1000); // Pausa de 1 segundo
                            System.out.print("."); // Añade un punto
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(); // Nueva línea después del mensaje
                    break; // Sale del loop y termina el programa
                }
            } while (menu != 6);

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════

         // SYSTÈME EN FRANÇAIS:
        } if (idioma == 5) {
            // Données Enregistrées dans le Système
            tituloDaOrientacao[0] = "Manuel d'Opération des Moteurs";
            tipoDaOrientacao[0] = "Manuel d'Opération";
            descricaoDaOrientacao[0] = "Instructions détaillées sur l'utilisation correcte et efficace des équipements.";
            tituloDaOrientacao[1] = "Procédure de Sécurité pour l'Installation Électrique";
            tipoDaOrientacao[1] = "Procédure de Sécurité";
            descricaoDaOrientacao[1] = "Instructions sur la façon d'effectuer la maintenance et les réparations des équipements.";
            tituloDaOrientacao[2] = "Maintenance des Moteurs Électriques";
            tipoDaOrientacao[2] = "Maintenance et Réparations";
            descricaoDaOrientacao[2] = "Procédures pour effectuer des tests de fonctionnement et diagnostiquer les pannes des équipements.";
            tituloDaOrientacao[3] = "Test de Diagnostic des Transformateurs";
            tipoDaOrientacao[3] = "Tests et Diagnostic";
            descricaoDaOrientacao[3] = "Procédures pour effectuer des tests de fonctionnement et diagnostiquer les pannes des équipements.";
            tituloDaOrientacao[4] = "Manuel de Conduite dans le Secteur d'Assemblage";
            tipoDaOrientacao[4] = "Manuel de Conduite et Opérations Sectorielles";
            descricaoDaOrientacao[4] = "Instructions sur la façon dont les collaborateurs doivent agir dans certains secteurs de l'entreprise, en mettant l'accent sur les bonnes pratiques et les processus spécifiques à chaque domaine.";
            tituloDaOrientacao[5] = "Procédure de Sécurité avec Risque d'Électrocution";
            tipoDaOrientacao[5] = "Procédure de Sécurité";
            descricaoDaOrientacao[5] = "Instructions sur la façon d'effectuer la maintenance et les réparations des équipements.";
            tituloDaOrientacao[6] = "Maintenance des Générateurs d'Énergie";
            tipoDaOrientacao[6] = "Maintenance et Réparations";
            descricaoDaOrientacao[6] = "Procédures pour effectuer des tests de fonctionnement et diagnostiquer les pannes des équipements.";
            tituloDaOrientacao[7] = "Test de Fonctionnement des Équipements d'Automatisation";
            tipoDaOrientacao[7] = "Tests et Diagnostic";
            descricaoDaOrientacao[7] = "Procédures pour effectuer des tests de fonctionnement et diagnostiquer les pannes des équipements.";
            tituloDaOrientacao[8] = "Manuel d'Opération des Équipements de Soudage";
            tipoDaOrientacao[8] = "Manuel d'Opération";
            descricaoDaOrientacao[8] = "Instructions détaillées sur l'utilisation correcte et efficace des équipements.";
            tituloDaOrientacao[9] = "Procédure de Sécurité dans le Secteur d'Assemblage";
            tipoDaOrientacao[9] = "Procédure de Sécurité";
            descricaoDaOrientacao[9] = "Instructions sur la façon d'effectuer la maintenance et les réparations des équipements.";
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // MENU
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
                System.out.print("Sélectionnez une option: ");
                menu = input.nextInt();
                input.nextLine();
                // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                // 1 ENREGISTRER
                if (menu == 1) {
                    if (i >= tituloDaOrientacao.length) {
                        String[] novoTitulo = new String[tituloDaOrientacao.length + 1];
                        String[] novoTipo = new String[tipoDaOrientacao.length + 1];
                        String[] novaDescricao = new String[descricaoDaOrientacao.length + 1];
                        for (int j = 0; j < tituloDaOrientacao.length; j++) {
                            novoTitulo[j] = tituloDaOrientacao[j];
                            novoTipo[j] = tipoDaOrientacao[j];
                            novaDescricao[j] = descricaoDaOrientacao[j];
                        }
                        tituloDaOrientacao = novoTitulo;
                        tipoDaOrientacao = novoTipo;
                        descricaoDaOrientacao = novaDescricao;
                    }
                    System.out.println("\n\nÉcrivez le titre de l'orientation: ");
                    tituloDaOrientacao[i] = input.nextLine();
                    System.out.println(
                            "\nÉcrivez le Type d'orientation: [Manuel d'Opération, Procédure de Sécurité, Maintenance et Réparations, Tests et Diagnostic ou Manuel de Conduite et Opérations Sectorielles]: 	");
                    tipoDaOrientacao[i] = input.nextLine();
                    System.out.println("\nÉcrivez la description de l'orientation: ");
                    descricaoDaOrientacao[i] = input.nextLine();
                    i++; // Incrémente l'index après l'ajout
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 2 RECHERCHER
                } else if (menu == 2) {

                    Set<String> tiposUnicos = new HashSet<>(); // Set pour éviter les doublons de types
                    for (int d = 0; d < i; d++) {
                        tiposUnicos.add(tipoDaOrientacao[d]);
                    }
                    // Affiche les types d'orientation uniques
                    System.out.println("\nTypes d'Orientations disponibles...\n");
                    for (String tipo : tiposUnicos) {
                        System.out.println("📂 Type d'Orientation: " + tipo);
                    }
                    System.out.println("\n\nRecherchez le type d'orientation: ");
                    String nomeTipo = input.nextLine();
                    boolean encontrado = false;
                    for (int j = 0; j < i; j++) {
                        if (normalizar(nomeTipo).equals(normalizar(tipoDaOrientacao[j]))) {
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("\n❌ Type d'orientation non trouvé!");
                        continue;
                    }
                    System.out.println("\n══════════════════════════════════════════════════════════════════════════");
                    System.out.println("Tous les titres avec le type d'orientation: " + nomeTipo);
                    System.out.println("══════════════════════════════════════════════════════════════════════════\n");
                    // Affiche les titres des items du type sélectionné
                    for (int n = 0; n < i; n++) {
                        if (normalizar(tipoDaOrientacao[n]).equals(normalizar(nomeTipo))) {
                            System.out.println("🔖 " + tituloDaOrientacao[n]);
                        }
                    }
                    System.out.println("\n\nSélectionnez un titre d'orientation: ");
                    String tituloSelecionado = input.nextLine();
                    boolean tituloEncontrado = false;
                    // Affiche le titre, type et description de l'item sélectionné
                    for (int l = 0; l < i; l++) {
                        if (normalizar(tituloSelecionado).equals(normalizar(tituloDaOrientacao[l]))) {
                            tituloEncontrado = true;
                            // Affiche le titre, type et description de l'item sélectionné
                            System.out.println("\n----------------------------------------");
                            System.out.println("🔖 Titre de l'Orientation: " + tituloDaOrientacao[l]);
                            System.out.println("📂 Type d'Orientation: " + tipoDaOrientacao[l]);
                            System.out.println("📝 Description: " + descricaoDaOrientacao[l]);
                            System.out.println("----------------------------------------");
                            break;
                        }
                    }
                    if (!tituloEncontrado) {
                        System.out.println("\n❌ Titre non trouvé! Vous pouvez réessayer.");
                        continue;
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 3 MODIFIER
                } else if (menu == 3) {
                    // Set pour éviter les doublons de types
                    Set<String> tiposUnicos1 = new HashSet<>();
                    for (int z = 0; z < i; z++) {
                        tiposUnicos1.add(tipoDaOrientacao[z]);
                    }
                    // Affiche les types d'orientation uniques pour modification
                    System.out.println("\nTypes d'Orientations disponibles pour modification...\n");
                    for (String tipo : tiposUnicos1) {
                        System.out.println("📂 Type d'Orientation: " + tipo);
                    }
                    System.out.println("\nÉcrivez le type d'orientation que vous souhaitez changer: ");
                    atualizarOrientacao = input.nextLine();
                    String tipoAtualNormalizado = normalizar(atualizarOrientacao);
                    boolean tipoEncontrado = false;
                    // Recherche le type d'orientation à modifier
                    for (int h = 0; h < i; h++) {
                        if (normalizar(tipoDaOrientacao[h]).equals(tipoAtualNormalizado)) {
                            tipoEncontrado = true;
                            System.out.println("\n\nType d'Orientation sélectionné: " + tipoDaOrientacao[h]
                                    + "\n\nNouveau Type: ");
                            atualizarOrientacao = input.nextLine();
                            tipoDaOrientacao[h] = atualizarOrientacao;
                            break;
                        }
                    }
                    if (!tipoEncontrado) {
                        System.out.println("\n❌ Type d'orientation non trouvé pour modification!");
                    }

                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 4 SUPPRIMER
                } else if (menu == 4) {
                    String produtoRemovido;
                    System.out.println("\n\nItems disponibles: \n");
                    for (int p = 0; p < i; p++) {
                        System.out.println("📚 " + tituloDaOrientacao[p]);
                    }
                    System.out.println("\nÉcrivez l'item que vous souhaitez supprimer: ");
                    produtoRemovido = input.nextLine();
                    String nomeProdutoNormalizado = normalizar(produtoRemovido);
                    boolean removido = false;
                    for (int k = 0; k < i; k++) {
                        if (normalizar(tituloDaOrientacao[k]).equals(nomeProdutoNormalizado)) {
                            for (int j = k; j < i - 1; j++) {
                                tituloDaOrientacao[j] = tituloDaOrientacao[j + 1];
                                tipoDaOrientacao[j] = tipoDaOrientacao[j + 1];
                            }
                            tituloDaOrientacao[i - 1] = null;
                            tipoDaOrientacao[i - 1] = null;
                            i--;
                            removido = true;
                            break;
                        }
                    }
                    if (removido) {
                        System.out.println("\nItem supprimé avec succès!");
                        System.out.println("\n\nItems après suppression:\n");
                        for (int p = 0; p < i; p++) {
                            if (tituloDaOrientacao[p] != null) {
                                System.out.println("📂 " + tituloDaOrientacao[p]);
                            }
                        }
                    } else {
                        System.out.println("Item " + produtoRemovido + " non trouvé pour suppression!");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 5 AFFICHER
                } else if (menu == 5) {

                    System.out.println("\n\n════════════════════════════════════════");
                    System.out.println("     📚 ORIENTATIONS ENREGISTRÉES         ");
                    System.out.println("════════════════════════════════════════");
                    for (int d = 0; d < i; d++) {
                        System.out.println("\n🔖 Titre de l'Orientation: " + tituloDaOrientacao[d]);
                        System.out.println("📂 Type d'Orientation: " + tipoDaOrientacao[d]);
                        // Vérifie si une description personnalisée a été enregistrée
                        String descricaoExibida = descricaoDaOrientacao[d] != null
                                && !descricaoDaOrientacao[d].isEmpty()
                                        ? descricaoDaOrientacao[d] // Affiche la description personnalisée
                                        : ""; // Si pas de description personnalisée, reste vide
                        // Ajoute la description standard si aucune description personnalisée
                        if (descricaoExibida.isEmpty()) {
                            switch (tipoDaOrientacao[d].toLowerCase()) {
                                case "manuel d'opération":
                                    descricaoExibida = "Instructions détaillées sur l'utilisation correcte et efficace des équipements. \n📝 Exemples: Manuel d'opération des moteurs, transformateurs, générateurs, etc.";
                                    break;
                                case "procédure de sécurité":
                                    descricaoExibida = "Procédures détaillées pour garantir la sécurité lors de l'opération des équipements et installations électriques. \n📝 Exemples: Procédure de sécurité pour installation électrique, risque d'électrocution, etc.";
                                    break;
                                case "maintenance et réparations":
                                    descricaoExibida = "Instructions pour la maintenance et réparations des équipements, systèmes et dispositifs. \n📝 Exemples: Maintenance des moteurs électriques, générateurs d'énergie, etc.";
                                    break;
                                case "tests et diagnostic":
                                    descricaoExibida = "Procédures pour tester et diagnostiquer des problèmes sur les équipements et systèmes. \n📝 Exemples: Test de diagnostic des transformateurs, automatisation, etc.";
                                    break;
                                case "manuel de conduite et opérations sectorielles":
                                    descricaoExibida = "Normes et instructions pour la conduite dans des secteurs spécifiques et leurs opérations. \n📝 Exemples: Manuel de conduite dans le secteur d'assemblage, etc.";
                                    break;
                                default:
                                    descricaoExibida = "Description standard non disponible.";
                            }
                        }
                        // Affiche la description
                        System.out.println("📝 Description: " + descricaoExibida);
                        System.out.println("\n----------------------------------------");
                    }
                    // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
                    // 6 QUITTER
                } else if (menu == 6) {
                    System.out.print("\nSortie en cours");

                    for (int s = 0; s < 3; s++) { // Ajoutera 3 points au total
                        try {
                            Thread.sleep(1000); // Pause de 1 seconde
                            System.out.print("."); // Ajoute un point
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(); // Nouvelle ligne après le message
                    break; // Sort de la boucle et termine le programme
                }
            } while (menu != 6);

            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
            // ══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\

        }
    }
}

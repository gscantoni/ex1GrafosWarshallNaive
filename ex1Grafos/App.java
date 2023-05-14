package ex1Grafos;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	
    	 long startTime, endTime;
    	 
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        int choice;

        System.out.println("Selecione o tamanho do grafo:");
        System.out.println("1. 100 vértices");
        System.out.println("2. 1.000 vértices");
        System.out.println("3. 10.000 vértices");
        System.out.println("4. 100.000 vértices");

        choice = scanner.nextInt();

        switch (choice) {
        case 1:
            Grafo.generateRandomGraph(100, "grafo_100.txt");
            
            int subChoice;
            boolean subMenu = true;
            
            while (subMenu) {
            	System.out.println("Você está no submenu 1");
                System.out.println("Selecione uma opção:");
                System.out.println("1. Busca naive");
                System.out.println("2. Busca Warshall");
                System.out.println("3. Base e Anti-Base");
                System.out.println("4. Voltar ao menu principal");
                
                subChoice = scanner.nextInt();
                
                switch (subChoice) {
                    case 1:
                        startTime = System.nanoTime();
                        grafo.leOGrafoPeloArquivo("grafo_100.txt");
                        grafo.calculaFechamentoTransitivo();
                        endTime = System.nanoTime();
                        System.out.println("Tempo gasto para a realizar a busca naive: " + (endTime - startTime) + " nanosegundos");
                        break;
                    case 2:
                        startTime = System.nanoTime();
                        grafo.leOGrafoPeloArquivo("grafo_100.txt");
                        grafo.warshall();
                        endTime = System.nanoTime();
                        System.out.println("Tempo gasto para a realizar a busca Warshall: " + (endTime - startTime) + " nanosegundos");
                        break;
                    case 3:
                        startTime = System.nanoTime();
                        grafo.leOGrafoPeloArquivo("grafo_100.txt");
                        grafo.AchaBaseEAntiBase();
                        endTime = System.nanoTime();
                        System.out.println("Tempo gasto para a realizar a busca de base e anti base: " + (endTime - startTime) + " nanosegundos");
                        break;
                    case 4:
                        subMenu = false; // Sair do sub-menu e voltar ao menu principal
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
            break;
            case 2:
                Grafo.generateRandomGraph(1000, "grafo_1000.txt");

                int subChoice2;
                boolean subMenu2 = true;
                
                while (subMenu2) {
                	System.out.println("Você está no submenu 2");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1. Busca naive");
                    System.out.println("2. Busca Warshall");
                    System.out.println("3. Base e Anti-Base");
                    System.out.println("4. Voltar ao menu principal");
                    
                    subChoice2 = scanner.nextInt();
                    
                    switch (subChoice2) {
                        case 1:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_1000.txt");
                            grafo.calculaFechamentoTransitivo();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca naive: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 2:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_1000.txt");
                            grafo.warshall();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca Warshall: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 3:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_1000.txt");
                            grafo.AchaBaseEAntiBase();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca de base e anti base: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 4:
                            subMenu = false; // Sair do sub-menu e voltar ao menu principal
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
                break;

            case 3:
                Grafo.generateRandomGraph(10000, "grafo_10000.txt");

                int subChoice3;
                boolean subMenu3 = true;
                
                while (subMenu3) {
                	System.out.println("Você está no submenu 3");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1. Busca naive");
                    System.out.println("2. Busca Warshall");
                    System.out.println("3. Base e Anti-Base");
                    System.out.println("4. Voltar ao menu principal");
                    
                    subChoice3 = scanner.nextInt();
                    
                    switch (subChoice3) {
                        case 1:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.calculaFechamentoTransitivo();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca naive: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 2:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.warshall();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca Warshall: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 3:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.AchaBaseEAntiBase();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca de base e anti base: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 4:
                            subMenu = false; // Sair do sub-menu e voltar ao menu principal
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
                break;

            case 4:
                Grafo.generateRandomGraph(100000, "grafo_100000.txt");
                
                int subChoice4;
                boolean subMenu4 = true;
                
                while (subMenu4) {
                	System.out.println("Você está no submenu 4");
                    System.out.println("Selecione uma opção:");
                    System.out.println("1. Busca naive");
                    System.out.println("2. Busca Warshall");
                    System.out.println("3. Base e Anti-Base");
                    System.out.println("4. Voltar ao menu principal");
                    
                    subChoice4 = scanner.nextInt();
                    
                    switch (subChoice4) {
                        case 1:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.calculaFechamentoTransitivo();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca naive: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 2:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.warshall();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca Warshall: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 3:
                            startTime = System.nanoTime();
                            grafo.leOGrafoPeloArquivo("grafo_10000.txt");
                            grafo.AchaBaseEAntiBase();
                            endTime = System.nanoTime();
                            System.out.println("Tempo gasto para a realizar a busca de base e anti base: " + (endTime - startTime) + " nanosegundos");
                            break;
                        case 4:
                            subMenu = false; // Sair do sub-menu e voltar ao menu principal
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
                break;

        }

        scanner.close();
    }

  
}

	package ex1Grafos;
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;
	
	public class Grafo {
		private int numVertices;
		private int numArestas;
		private List<Integer>[] adjacencias;
	    private boolean[][] fechamentoTransitivo;
	    public int[][] matrixDeAdjacencia;
	    
	   
	    
	    public static void generateRandomGraph(int numVertices, String fileName) {
	        Random random = new Random();
	        int numArestas = numVertices * 2; // Definindo um número de arestas proporcional ao número de vértices
	
	        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
	            writer.println(numVertices);
	            writer.println(numArestas);
	
	            for (int i = 0; i < numArestas; i++) {
	                int origem = random.nextInt(numVertices) + 1;
	                int destino = random.nextInt(numVertices) + 1;
	                int peso = random.nextInt(10) + 1; // Peso da aresta (opcional)
	
	                writer.println(origem + " " + destino + " " + peso);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void leOGrafoPeloArquivo(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            numVertices = Integer.parseInt(reader.readLine());
	            numArestas = Integer.parseInt(reader.readLine());

	            adjacencias = new ArrayList[numVertices];
	            fechamentoTransitivo = new boolean[numVertices][numVertices];
	            matrixDeAdjacencia = new int[numVertices][numVertices];

	            // Inicializa as listas de adjacências para cada vértice
	            for (int i = 0; i < numVertices; i++) {
	                adjacencias[i] = new ArrayList<>();
	            }

	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(" ");
	                int origem = Integer.parseInt(parts[0]) - 1;
	                int destino = Integer.parseInt(parts[1]) - 1;

	                adjacencias[origem].add(destino);
	                fechamentoTransitivo[origem][destino] = true;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    public void calculaFechamentoTransitivo() {
	        for (int k = 0; k < numVertices; k++) {
	            for (int i = 0; i < numVertices; i++) {
	                for (int j = 0; j < numVertices; j++) {
	                	fechamentoTransitivo[i][j] = fechamentoTransitivo[i][j] || (fechamentoTransitivo[i][k] && fechamentoTransitivo[k][j]);
	                }
	            }
	        }
	    }
	    public boolean[][] FechamentoTransitivo() {
	        for (int k = 0; k < numVertices; k++) {
	            for (int i = 0; i < numVertices; i++) {
	                for (int j = 0; j < numVertices; j++) {
	                	fechamentoTransitivo[i][j] = fechamentoTransitivo[i][j] || (fechamentoTransitivo[i][k] && fechamentoTransitivo[k][j]);
	                }
	            }
	        }
	        return fechamentoTransitivo;
	    }
	    
	    public void warshall() {
	    	boolean acessa[][] = new boolean[numVertices][numVertices];
	
	    	
	    	
	        for (int i = 0; i < numVertices; i++)
	            for (int j = 0; j < numVertices; j++)
	               acessa[i][j] = adjacencias[i].contains(j);
	
	        for (int k = 0; k < numVertices; k++) {
	            for (int i = 0; i < numVertices; i++) {
	                for (int j = 0; j < numVertices; j++) {
	                    acessa[i][j] = acessa[i][j] || (acessa[i][k] && acessa[k][j]);
	                }
	            }
	        }
	    }
	    
	    
	    
	    public void AchaBaseEAntiBase() {
	        int n = matrixDeAdjacencia.length;
	        boolean[][] fechamento = FechamentoTransitivo();
	        
	        List<Integer> base = new ArrayList<>();
	        List<Integer> antiBase = new ArrayList<>();
	        
	        // Verifica se o vértice i pertence à base ou à antibase
	        for (int i = 0; i < n; i++) {
	            boolean EUmaBase = true;
	            boolean EUmaAntiBase = true;
	            
	            for (int j = 0; j < n; j++) {
	                if (i != j) {
	                    // Se existe um caminho de i a j, então i não pode ser da base
	                    if (fechamento[i][j]) {
	                        EUmaBase = false;
	                    }
	                    
	                    // Se não existe um caminho de j a i, então i não pode ser da antibase
	                    if (!fechamento[j][i]) {
	                        EUmaAntiBase = false;
	                    }
	                }
	            }
	            
	            if (EUmaBase) {
	                base.add(i);
	            }
	            
	            if (EUmaAntiBase) {
	                antiBase.add(i);
	            }
	        }
	        
	        // Imprime a base e a antibase
	        System.out.println("Base: " + base);
	        System.out.println("Antibase: " + antiBase);
	    }
	
		public int getNumVertices() {
			return numVertices;
		}
	
		public void setNumVertices(int numVertices) {
			this.numVertices = numVertices;
		}
	
		public int getNumArestas() {
			return numArestas;
		}
	
		public void setNumArestas(int numArestas) {
			this.numArestas = numArestas;
		}
	
	
	}
	

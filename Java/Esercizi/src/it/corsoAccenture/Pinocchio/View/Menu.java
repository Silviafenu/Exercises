package it.corsoAccenture.Pinocchio.View;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import it.corsoAccenture.Pinocchio.Entities.Gatto;

public class Menu {
	private static Scanner scan = new Scanner(System.in);


	public void startMenu(){
		int scelta; 
		String stringLunga = "";
		
		do {
		System.out.println("Scelte: "
				+ "\n[1] -► Stampa del contenuto su console"
				+ "\n[2] -► Copia il file da pinocchio a pinocchio2"
				+ "\n[3] -► Leggere 3 elementi a piacere "
				+ "\n[4] -► Contare il numero di parole diverse");
		 scelta = scan.nextInt(); 
		}
		while(scelta != 4); 
		
	switch(scelta) {
		case 1 : 
					//1 punto: lettura file
					File file = new File("C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Pinocchio\\File/Pinocchio.txt"); 
		
					//controllo l'esistenza del file
					if(!file.exists()) {
						try {
							file.createNewFile();
						} catch (IOException e) {
							System.out.println("Non sono riuscito a creare il file");
						}
					}
		
					//lettura file 
					char[] caratteri =  new char[1024];
					int nCaratteri = 0;
					
					try {
						BufferedReader bufferRead = new BufferedReader(new FileReader(file));
						
						//stampa del file
						while((nCaratteri = bufferRead.read(caratteri)) != -1) {
							for(int i = 0; i < nCaratteri; i++) {
								System.out.print(caratteri[i]);
							}
						}
						bufferRead.close(); 				
					}
					catch (FileNotFoundException e) {
						System.out.println("Non ho trovato file nel percorso specificato ");
					} 
					catch (IOException e) {
						System.out.println("Non riesco a leggere il contenuto del file");
					}
					break; 
		
	   case 2: 
				//2 punto: copia file		
				String sourcePath = "C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Pinocchio\\File/Pinocchio.txt";
				String destinationPath = "C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Pinocchio\\File/Pinocchio2.txt";
		
				//verifico se è presente il mio file
				try {
					InputStream input = new FileInputStream(sourcePath);
			
					OutputStream output = new FileOutputStream(destinationPath);

			
					//copio il contenuto nell'altro file
					byte[] byteBuff = new byte[1024]; 
					int byteletti = 0; 
			
					while((byteletti = input.read(byteBuff)) >= 0) {
						output.write(byteBuff, 0, byteletti); 
					}
					System.out.println("Copia avvenuta");
					output.close();
					input.close(); 
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch(Exception e) {
					System.out.println("errore");
				}
				break; 
				
		 case 3: 
		    	 //3 punto
		    	 File file2 = new File("C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Pinocchio\\File/File2.txt"); 
		
		    	 //controllo l'esistenza del file
		    	 if(!file2.exists()) {
		    		 try {
		    			 file2.createNewFile();
		    		 } catch (IOException e) {
		    			 System.out.println("Non sono riuscito a creare il file");
					}
				  }
				
		    	 Gatto gatto = new Gatto(" Pallina", "Siamese", 4); 
		    	 Gatto gatto1 = new Gatto("Minù", "Ragamuffin", 2);
		    	 Gatto gatto2 = new Gatto("Luna", "Korat", 3); 
	    
	
				    	 FileOutputStream fileOutputStream;
				try {
						fileOutputStream = new FileOutputStream(file2);
						ObjectOutputStream objectOutputStream = new  ObjectOutputStream(fileOutputStream);
						
						//li passo l'ggetto
						objectOutputStream.writeObject(gatto); 
						objectOutputStream.writeObject(gatto1); 
						objectOutputStream.writeObject(gatto2); 
		
						System.out.println("Oggetto SERIALIZZATO CORRETTAMENTE");
						System.out.println(gatto);
						System.out.println(gatto1);
						System.out.println(gatto2);
						
						fileOutputStream.close();
						objectOutputStream.close(); 
					}
				catch (FileNotFoundException e) {
					 	System.out.println("File non trovato");		
					 	} 
				catch (IOException e) {
					 	System.out.println("Non posso recuperare gli oggetti all'interno del file");	
					} 	
				
				//deserializzazione per prendere l'oggetto
				FileInputStream fileInputStream;
				try {
					fileInputStream = new FileInputStream(file2);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					
					Gatto gattoDes = (Gatto)objectInputStream.readObject();
					Gatto gattoDes1 = (Gatto)objectInputStream.readObject();
					Gatto gattoDes2 = (Gatto)objectInputStream.readObject();
		
					System.out.println("\n Oggetto DESERIALIZZATO");
					System.out.println(gattoDes);
					System.out.println(gattoDes1);
					System.out.println(gattoDes2);
					
					fileInputStream.close();
					objectInputStream.close();		
					
				}
				catch (FileNotFoundException e) {
				 	System.out.println("File non trovato");		
				} 
				catch (IOException e) {
					 	System.out.println("Non posso recuperare gli oggetti all'interno del file");	
				} 
				catch (ClassNotFoundException e) {
					 System.out.println("Le instanze della classe ricercata non è presente all'interno del file");
				} 
				break; 
			
		 case 4: 				
				//4 punto
				//parole con doppioni
				File file3 = new File("C:\\Users\\silvf\\OneDrive\\Desktop\\Java Academy\\EserciziCorso\\src\\it\\corsoAccenture\\Pinocchio\\File/Pinocchio.txt"); 
				
				char[] caratteri2 =  new char[1024];
				int nCaratteri2 = 0;
				
				try {
					BufferedReader bufferRead = new BufferedReader(new FileReader(file3));
		
					while((nCaratteri = bufferRead.read(caratteri2)) != -1) {
						for(int i = 0; i < nCaratteri; i++) {
							stringLunga += caratteri2[i]; 
						}
					}
					bufferRead.close(); 				
				}
				catch (FileNotFoundException e) {
					System.out.println("Non ho trovato file nel percorso specificato ");
				} 
				catch (IOException e) {
					System.out.println("Non riesco a leggere il contenuto del file");
				}
				
				String[] text = stringLunga.toLowerCase().trim().split("[\\s\\p{Punct}&&[^\\p{L}]]+");
				System.out.println("Nel libro ci sono: "+ text.length + " parole");
				
				Set<String> nienteDuplicati = new HashSet<String>();
				for(int i = 0; i < text.length; i++) {
					nienteDuplicati.add(text[i]); 
				}
				
				System.out.println("\nPaole senza duplicati: " + nienteDuplicati.size());
				
				break; 
				}
			}
		
		}

/*Inserire un vettore contenente il nome di 20 alunni
 * Inserire un vettore contenente 10 nomi di discipline
 * Inserire i voti degli alunni nelle singole discipline in una materia
 * Calcolare la media di ogni alunno e ordinarla */
import java.io.*;
public class OrdinamentoVoti {
	public static void main (String args[])
	{
		//Inpostazione standard input
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader tastiera = new BufferedReader(input);
		
		//Dichiarazione variabili
		final int alunno = 2, riga = 2, colonna = 4, materia = 4;
		int media[] = new int[alunno];
		String materie[] = new String[materia];
		String alunni[] = new String[alunno];
		int voti[][] = new int[riga][colonna];
		int i,j, s = 0, x = 0;
		String y;
		int scelta = 0;
		String opz;
		
		//Menù scelta
		do
		{
			System.out.println("1. Inserimento alunni in un vettore;");
			System.out.println("2. Inserimento discipline in un vettore;");
			System.out.println("3. Inserimento voti alunni in una matrice;");
			System.out.println("4. Calcolo/Ordinamento e stampa media di ogni alunno;");
			System.out.print("Fai una scelta: ");
			try 
			{
				String numeroLetto = tastiera.readLine();
				scelta = Integer.valueOf(numeroLetto).intValue();
			}
			catch (Exception e)
			{
				System.out.println("Il valore inserito non è valido!");
			}
		
		//Switch Case per effettuare la scelta sull'operazione da eseguire
		switch (scelta)
		{
			case 1:
				//Inserimento alunni nel vettore
				System.out.println("Registrazione alunni: ");
				for (i=0; i<alunno; i++)
				{
					System.out.print("Inserisci alunno n. "+i+": ");
					try {
						alunni[i] = tastiera.readLine();
						}
					catch (Exception e)
					{
						System.out.println("Il valore inserito non è valido! ");
						i--;
					}
				}
				break;
			case 2:
				//Inserimento materie nel vettore
				System.out.println("Registrazione discipline ");
				for (i=0; i<materia; i++)
				{
					System.out.print("Inserisci disciplina n. "+i+": ");
					try {
							materie[i] = tastiera.readLine();
						}
					catch (Exception e)
					{
						System.out.println("Il valore inserito non è valido! ");
					}
				}
				break;
			case 3:
				//Inserimento voti nella matrice
				System.out.println("Registrazione valutazioni ");
				for (i=0; i<riga; i++)
				{
					System.out.println("Stai inserendo i voti di "+"'"+alunni[i]+"'");
					for (j=0; j<colonna; j++)
					{
						do {
						System.out.print("Inserire valutazione nella disciplina "+"'"+materie[j]+"'"+": ");
						try {
								String numeroLetto = tastiera.readLine();
								voti[i][j] = Integer.valueOf(numeroLetto).intValue();
							}
						catch (Exception e)
						{
							System.out.println("Il valore inserito non è valido! ");
							i--;
						}
						if (voti[i][j] > 10)
							System.out.println("Inserisci un valore compreso tra 0 e 10!");
						}
						while (voti[i][j] >10);
					}
				}
				break;
			case 4:
				//Calcolo media dei voti per alunno
				for (i=0; i<riga; i++)
				{
					s = 0;
					for (j=0; j<colonna; j++)
					{
						s = s + voti[i][j];
					}
					media[i] = s / materia;
				}
				
				//Ordinamento media
				for (i=0; i<riga; i++)
				{
					for (j=0; j<colonna-1; j++)
					{
						if (media[i] > x)
						{
							x = media[i];
							media[i] = media[j];
							media[j] = x;
							
							y = alunni[i];
							alunni[i] = alunni[j];
							alunni[j] = y;
						}
					}
				}
				
				//Stampa media ordinata
				System.out.println("Stampa medie alunni ordinate ");
				for (i=0; i<riga; i++)
				{
						System.out.println("Alunno: "+"'"+alunni[i]+"'"+"     Media: "+media[i]);
				}
				break;
				default:
					System.out.println("Scelta non valida!" );
					break;
		}
		System.out.print("Vuoi eseguire un'altra scelta?(y/n): ");
		try
		{
			opz = tastiera.readLine();
		}
		catch (Exception e)
		{
			System.out.println("Il valore inserito non è valido!");
			return;
		}
		}
		while (opz.equals("y"));
		}
}

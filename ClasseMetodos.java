/*
 
1)	Cadastrar 200 registros com votos de eleitores a partir do método  
    NúmeroSeção       (0 a 10)     (1)
    NúmeroCandidato (0 a 300) (1) 
(1)	Utilizar método RANDOM ()
             FCADRASTRAVOTAÇÃO(função);

2)	Classificar os registros em memória por NumeroSeção e exibir mensagem 
  “dados classificados”      
             FCLASSIFICASEÇÃO(função);

3)	Gravar dados da votação em arquivo Votação2021.txt e exibir mensagem “arquivo gerado”      
             FGRAVAVOTAÇÃO(função);

4)	Chamada de Menu para mostrar Indicadores;
 */
package SistemaVotação_io;
import java.io.*;
import javax.swing.*;
import java.util.Random;
public class ClasseMetodos 
{
    public Votação [ ] FCADRASTRAVOTAÇÃO (Votação[] votação)throws IOException
    {
        int i; String fileName = "Votação2025.txt";
        BufferedWriter CadastraVotação = new BufferedWriter(new FileWriter(fileName));
        Random random = new Random();
        for (i = 0; i < 200; i++) 
        {
            votação[i] = new Votação();
        }
        for (i = 0; i < 200; i++) 
        {
            votação[i].NumeroSeção = random.nextInt(11);
            CadastraVotação.write(Integer.toString(votação[i].NumeroSeção));
            CadastraVotação.newLine();

            // Gera número do candidato aleatoriamente (0 a 300)
            votação[i].NumeroCandidato = random.nextInt(301);
            CadastraVotação.write(Integer.toString(votação[i].NumeroCandidato));
            CadastraVotação.newLine();
        
        }
        System.out.println("GRAVAÇÃO FEITA COM SUCESSO");
        CadastraVotação.close();
        return votação;
    } 
 //2)	Classificar os registros em memória por NumeroSeção e exibir mensagem 
  //“dados classificados”      
  //FCLASSIFICASEÇÃO(função);
    public Votação [ ] FCLASSIFICASEÇÃO (Votação[] votação)throws IOException
    {
        int i,aux1,aux2,cont;
        aux1 = ( 0 );
        aux2  = ( 0 );
        for ( cont = 0 ; cont < 400 ; cont ++ )
        {
            for (i = 0; i < 199 ; i ++ )
            {
                if ( votação[i].NumeroSeção > votação[i+1].NumeroSeção )
                {
                    aux1 = ( votação[i].NumeroSeção );
                    aux2 = (votação[i].NumeroCandidato);
                    votação[i].NumeroSeção = ( votação[i+1].NumeroSeção);
                    votação[i].NumeroCandidato = ( votação[i+1].NumeroCandidato);
                    votação[i+1].NumeroSeção = ( aux1 );
                    votação[i+1].NumeroCandidato = ( aux2 );
                }
            }
        }
        System.out.println("Dados classificados");
        return votação;
    }
    //3)	Gravar dados da votação em arquivo Votação2021.txt e exibir mensagem “arquivo gerado”      
             //FGRAVAVOTAÇÃO(função);

    public Votação [ ] FGRAVAVOTAÇÃO (Votação[] votação)throws IOException
    {
        int i; String fileName = "Votação2025.txt";
        BufferedWriter GravaVotação = new BufferedWriter(new FileWriter(fileName));
        for ( i = 0; i < 200; i++) 
        {
            GravaVotação.write(votação[i].NumeroSeção + " " + votação[i].NumeroCandidato);
            GravaVotação.newLine();
        }
        System.out.println("arquivo gerado");
        GravaVotação.close();
        return votação;
    }
    //***************************************************************************************
    //4)	Chamada de Menu para mostrar Indicadores;
    //4.1) Quantidade de eleitores por Seção (procedimento);
    
    public void FQUANTIDADEELEITORES( Votação[] votação) throws IOException
    {
        int i,cont = 0 ;
        int[] contagemSecao = new int[11];
        for (i = 0; i <= 10; i++) 
        {
            contagemSecao[i] = 0;
        }
        for ( i = 0; i < 200 ; i++)
        {
            cont = ( votação[i].NumeroSeção );
            contagemSecao[cont]++;
        }
        System.out.println("Quantidade de eleitores por seção:");
        for (i = 0; i <= 10; i++) 
        {
            System.out.println("Seção " + i + ": " + contagemSecao[i] + " eleitores");
        }
    }
    //4.2) Número da Seção com maior e menor números de eleitores (procedimento);
    public void FMAIOREMENORELEITORES( Votação[] votação) throws IOException
    {
        int i,maior,menor,secaoMenor=0,secaoMaior=0,cont = 0 ;
        int[] contagemSecao = new int[11];
        for (i = 0; i <= 10; i++) 
        {
            contagemSecao[i] = 0;
        }
        for ( i = 0; i < 200 ; i++)
        {
            cont = ( votação[i].NumeroSeção );
            contagemSecao[cont]++;
        }
        maior = contagemSecao[0] ;
        menor = contagemSecao[0] ; 
        for (i = 1; i <= 10; i++) 
        {
            if (contagemSecao[i] > maior) 
            {
                maior = contagemSecao[i];
                secaoMaior = i;
            }
            if (contagemSecao[i] < menor)
            {
                menor = contagemSecao[i];
                secaoMenor = i;
            }
        } 
        System.out.println("Seção com maior quantidade de eleitores: " + secaoMaior + " (" + maior + " eleitores)");
        System.out.println("Seção com menor quantidade de eleitores: " + secaoMenor + " (" + menor + " eleitores)");
    }
    //4.3) Quantidade de votos por candidato (procedimento);
    public void FQUANTIDADEVOTOS( Votação[] votação) throws IOException
    {
        int i,cont = 0 ;
        int[] contagemVotos = new int[301];
        for (i = 0; i <= 300; i++) 
        {
            contagemVotos[i] = 0;
        }
        for ( i = 0; i < 200 ; i++)
        {
            cont = ( votação[i].NumeroCandidato );
            contagemVotos[cont]++;
        }
        System.out.println("Quantidade de votos por candidato:");
        for (i = 0; i <= 300; i++) 
        {
            System.out.println("Candidato " + i + ": " + contagemVotos[i] + " votos");
        }
    }
    //4.4) Exibir os 10 candidatos mais votados e suas quantidades (procedimento);
    public void FMAISVOTADOS(Votação[] votação) throws IOException 
    {
        int i, j, auxVotos, auxCand;
        int[] contagemVotos = new int[301]; 
        for (i = 0; i <= 300; i++)
        {
          contagemVotos[i] = 0;  
        } 
        for (i = 0; i < 200; i++) 
        {
            int cand = votação[i].NumeroCandidato;
            contagemVotos[cand]++;
        }
        int[] candidatos = new int[301];
        for (i = 0; i <= 300; i++)
        { 
            candidatos[i] = i;
        }
        for (i = 0; i <= 300; i++) 
        {
            for (j = 0; j < 300; j++) 
            {
                if (contagemVotos[j] < contagemVotos[j + 1]) 
                {
                    auxVotos = contagemVotos[j];
                    contagemVotos[j] = contagemVotos[j + 1];
                    contagemVotos[j + 1] = auxVotos;
                    auxCand = candidatos[j];
                    candidatos[j] = candidatos[j + 1];
                    candidatos[j + 1] = auxCand;
                }
            }
        }
        System.out.println("Top 10 candidatos mais votados:");
        for (i = 0; i < 10; i++) 
        {
            System.out.println("Candidato " + candidatos[i] + ": " + contagemVotos[i] + " votos");
        }
    }       
}
    
  
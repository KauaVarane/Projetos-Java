/*
 Criar classe Votação2025, conforme:
----------------------------------------------------------------
|	SISTEMA DE VOTAÇÃO			|
|      1 – Carregar Seção/Número Eleitor 	|
|      2 – Classificar por Seção      		|
|      3 – Gravar Registros                                	|
|      4 – Mostrar Indicadores                                   |
|      9 – Finalizar                                           	|
----------------------------------------------------------------
 */
package SistemaVotação_io;
import java.io.IOException;
import javax.swing.JOptionPane;
public class ClassePrincipal 
{
    public static void main ( String args [ ] ) throws IOException
    {
        Votação [ ] votação = new Votação [200];
        ClasseMetodos m = new ClasseMetodos ();
        int opc = 0;
        while ( opc!= 9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Carregar Seção/Número Eleitor \n 2 – Classificar por Seção   \n 3 – Gravar Registros \n 4 - Mostrar Indicadores   \n 9 - Fim"));
            switch ( opc )
            {
                case 1 : votação = m.FCADRASTRAVOTAÇÃO(votação);
                break;
                case 2 : votação = m.FCLASSIFICASEÇÃO(votação);
                break;
                case 3 : votação = m.FGRAVAVOTAÇÃO(votação);
                break;
                case 4 : FMOSTRAINDICADORES(votação);
                break;
                case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
                break;
                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
        //-------------------------------------------------------------------------
        //|	    Mostrar Indicadores			                          |
        //|        Estatísticas de Votação em 2021		                  |
        //| 1 – Quantidade Eleitores por Seção	                                  |
        //| 2 – Seção com Maior e Menor número de Eleitores                       |
        //| 3 – Quantidade de votos por candidato                                 |
        //| 4 – 10 primeiros colocadas (nro cand. e qtd votos)                    |
        //| 9 – Finaliza consulta	                		          |
        //-------------------------------------------------------------------------
    public static void FMOSTRAINDICADORES(Votação[] votação)throws IOException
    {
        ClasseMetodos m = new ClasseMetodos ();
        int opc = 0;
        while ( opc!= 9)
        {
            opc = Integer.parseInt(JOptionPane.showInputDialog("1 – Quantidade Eleitores por Seção \n 2 – Seção com Maior e Menor número de Eleitores   \n 3 – Quantidade de votos por candidato \n 4 - 10 primeiros colocadas (nro cand. e qtd votos)   \n 9 - Fim"));
            switch ( opc )
            {
                case 1 : m.FQUANTIDADEELEITORES (votação);
                break;
                case 2 : m.FMAIOREMENORELEITORES(votação);
                break;
                case 3 : m.FQUANTIDADEVOTOS(votação);
                break;
                case 4 : m.FMAISVOTADOS(votação);
                break;
                case 9 : JOptionPane.showMessageDialog(null,"FINALIZADO");
                break;
                default: JOptionPane.showMessageDialog(null,"OPÇÃO INVÁLIDA");
            }
        }
    }
}

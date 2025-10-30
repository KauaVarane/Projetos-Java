/*
 Exercício:

Criar uma classe abstrata segundo:
............................................................................	
.	              	Votação               	         	.
.............................................................................
.    NumeroSeção        :      NumeroCandidato      . 
............................................................................
.             int	           :                 int                      .
............................................................................

 */
package SistemaVotação_io;
class Votação 
{
    int NumeroSeção ; 
    int NumeroCandidato ;
    Votação()
    {
        this(0, 0);
    }
    Votação( int pNumeroSeção , int pNumeroCandidato )
    {
        NumeroSeção = ( pNumeroSeção ) ; 
        NumeroCandidato = ( pNumeroCandidato ) ;
    }
}

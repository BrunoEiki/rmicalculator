package com.rmicalculator.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import com.rmicalculator.shared.Calculadora;
import com.rmicalculator.shared.DivisaoPorZeroException;
import com.rmicalculator.shared.Numero;
import com.rmicalculator.shared.NumeroImpl;
import com.rmicalculator.shared.NumeroInvalidoException;
import com.rmicalculator.shared.NumeroNegativoException;


public class ClienteCalculadora {

public static void main(String[] args) {
    try {
        String ipServidor = args[0]; // IP do servidor
        int porta = Integer.parseInt(args[1]);
        String nomeServico = args[2]; // Nome do serviço

        // Conecta ao Registry remoto
        Registry registry = LocateRegistry.getRegistry(ipServidor, porta);

        // Obtém o stub do serviço
        Calculadora calc = (Calculadora) registry.lookup(nomeServico);


    Scanner input = new Scanner(System.in);

    int choice = -1;
    
        while(choice != 0) {
            System.out.println("Calculator Main Menu\n");
            System.out.print("1.) Addition \n");
            System.out.print("2.) Subtraction.\n");
            System.out.print("3.) Multiplication.\n");
            System.out.print("4.) Division.\n");
            System.out.print("5.) Whole Division.\n");
            System.out.print("6.) Division Remainder.\n");
            System.out.print("7.) Exponentiation.\n");
            System.out.print("8.) Square Root\n");
            System.out.print("9.) Natural Logarithm\n");
            System.out.print("10.) Random Number\n");
            System.out.print("11.) Absolute Value\n");
            System.out.print("12.) Round Number\n");
            System.out.print("13.) Maximum Value\n");
            System.out.print("14.) Degrees to Radians\n");
            System.out.print("15.) Sine Function\n");
            System.out.print("16.) Average Calculation\n");
            System.out.print("17.) Exit\n");
            System.out.print("\nEnter Your Menu Choice: ");

            choice = input.nextInt();
            
            switch(choice){
                case 1:
                    //Definitions
                    Numero adNumf, adNuml, sum;
                    System.out.print("Please Enter The First Number: ");
                    adNumf = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    adNuml = new NumeroImpl(input.nextInt());
                    sum = calc.soma(adNumf,  adNuml);
                    System.out.print("The Sum Of Those Numbers is: " + sum.getValor() + "\n");
                    break;

                case 2: 
                    Numero subNum1, subNum2;
                    System.out.print("Please Enter The First Number: ");
                    subNum1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    subNum2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Subtraction Of Those Numbers is: " + calc.subtrai(subNum1,  subNum2).getValor() + "\n");
                    break;

                case 3:
                    Numero multNum1, multNum2;
                    System.out.print("Please Enter The First Number: ");
                    multNum1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    multNum2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Product Of Those Numbers is: " + calc.multiplica(multNum1,  multNum2).getValor() + "\n");
                    break;

                case 4: 
                    Numero divNum1, divNum2;
                    System.out.print("Please Enter The First Number: ");
                    divNum1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    divNum2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Product Of Those Numbers is: " + calc.divide(divNum1,  divNum2).getValor() + "\n");
                    break;

                case 5: 
                    Numero divInteiro1, divInteiro2;
                    System.out.print("Please Enter The First Number: ");
                    divInteiro1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    divInteiro2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Quotient Of Those Numbers is: " + calc.divideInteiro(divInteiro1,  divInteiro2).getValor() + "\n");
                    break;

                case 6: 
                    Numero divResto1, divResto2;
                    System.out.print("Please Enter The First Number: ");
                    divResto1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    divResto2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Remainder Of Those Numbers is: " + calc.restoDivisao(divResto1,  divResto2).getValor() + "\n");
                    break;

                case 7:
                    Numero expon1, expon2;
                    System.out.print("Please Enter The First Number: ");
                    expon1 = new NumeroImpl(input.nextInt());
                    System.out.print("\nPlease Enter The Second Number: ");
                    expon2 = new NumeroImpl(input.nextInt());
                    System.out.print("The Remainder Of Those Numbers is: " + calc.exponencia(expon1,  expon2).getValor() + "\n");
                    break;

                case 8: // Raiz Quadrada
                    Numero sqrtNum;
                    System.out.print("Please Enter The Number: ");
                    sqrtNum = new NumeroImpl(input.nextDouble());
                    try {
                        System.out.print("The Square Root is: " + 
                            calc.raizQuadrada(sqrtNum).getValor() + "\n");
                    } catch (NumeroNegativoException e) {
                        System.out.print("Error: Cannot calculate square root of negative number\n");
                    }
                    break;

                case 9: // Logaritmo Natural
                    Numero logNum;
                    System.out.print("Please Enter The Number: ");
                    logNum = new NumeroImpl(input.nextDouble());
                    try {
                        System.out.print("The Natural Logarithm is: " + 
                            calc.logaritmoNatural(logNum).getValor() + "\n");
                    } catch (NumeroInvalidoException e) {
                        System.out.print("Error: Number must be positive\n");
                    }
                    break;

                case 10: // Número Aleatório
                    Numero randMin, randMax;
                    System.out.print("Please Enter Minimum Value: ");
                    randMin = new NumeroImpl(input.nextDouble());
                    System.out.print("Please Enter Maximum Value: ");
                    randMax = new NumeroImpl(input.nextDouble());
                    System.out.print("Random Number is: " + 
                        calc.numeroAleatorio(randMin, randMax).getValor() + "\n");
                    break;

                case 11: // Valor Absoluto
                    Numero absNum;
                    System.out.print("Please Enter The Number: ");
                    absNum = new NumeroImpl(input.nextDouble());
                    System.out.print("The Absolute Value is: " + 
                        calc.valorAbsoluto(absNum).getValor() + "\n");
                    break;

                case 12: // Arredondamento
                    Numero roundNum;
                    System.out.print("Please Enter The Number: ");
                    roundNum = new NumeroImpl(input.nextDouble());
                    System.out.print("The Rounded Value is: " + 
                        calc.arredondar(roundNum).getValor() + "\n");
                    break;

                case 13: // Máximo entre dois números
                    Numero maxNum1, maxNum2;
                    System.out.print("Please Enter First Number: ");
                    maxNum1 = new NumeroImpl(input.nextDouble());
                    System.out.print("Please Enter Second Number: ");
                    maxNum2 = new NumeroImpl(input.nextDouble());
                    System.out.print("The Maximum Value is: " + 
                        calc.maximo(maxNum1, maxNum2).getValor() + "\n");
                    break;

                case 14: // Conversão Graus para Radianos
                    Numero degreesNum;
                    System.out.print("Please Enter Degrees: ");
                    degreesNum = new NumeroImpl(input.nextDouble());
                    System.out.print("Radians: " + 
                        calc.grausParaRadianos(degreesNum).getValor() + "\n");
                    break;

                case 15: // Seno
                    Numero sineDegrees;
                    System.out.print("Please Enter Degrees: ");
                    sineDegrees = new NumeroImpl(input.nextDouble());
                    System.out.print("Sine: " + 
                        calc.seno(sineDegrees).getValor() + "\n");
                    break;

                case 16: // Média
                    System.out.print("How many numbers to average? ");
                    int count = input.nextInt();
                    Numero[] numbers = new Numero[count];
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter number " + (i+1) + ": ");
                        numbers[i] = new NumeroImpl(input.nextDouble());
                    }
                    System.out.print("Average: " + 
                        calc.media(numbers).getValor() + "\n");
                    break;

                default :
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;
                
                }
            
            }

        try {
            calc.divide(new NumeroImpl(1), new NumeroImpl(0));
        } catch (DivisaoPorZeroException e) {
            System.out.println(
            "Tentou dividir por zero! Esta é uma exceção remota.");
        }

    } catch (Exception e) {
        System.err.println("Ocorreu um erro no cliente: " +
                            e.toString());
        }
    }
}

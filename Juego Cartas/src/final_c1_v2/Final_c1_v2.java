/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_c1_v2;

import javax.swing.*;

/**
 *
 * @author Facundo
 */
public class Final_c1_v2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int GanaOpierdeUs, GanaOpierdeM1, GanaOpierdeM2, puntosM1 = 0, puntosM2 = 0, puntosUs = 0;
        int ganador = 0;
        int puntosMayor = 0;
        
        String jugar = "si", jugadorMayor = "", resj1 = "", resj2 = "", resUs = "", cumplioj1 = "", cumplioj2 = "", cumplioUs = "";
        
        
        
        int[] tirada = new int[3];
        int[] cartaUs = new int[3];
        int[] m1_c = new int[3];
        int[] m2_c = new int[3];
        int[] cartaMayor = new int[3];

        JOptionPane.showMessageDialog(null,
                "¡BIenvenido al juego de la verdad!"
                + "\n "
                + "\n     Se repartira una carta al azar entre 1 y 12 para cada jugador."
                + "\nSiendo 1 la carta mas pequeña y 12 la mas alta.Debes predecir"
                + "\n si esa ronda vas a ganarla o perderla.Si se cumple tu"
                + "\n prediccion sumas puntos.Si el jugador no cumple su apuesta"
                + "\n no suma ningun punto."
                + "\n "
                + "\n - Si eliges ganar sumas 6 puntos"
                + "\n -Si eliges perder sumas 5 puntos"
                + "\n Si dos jugadores o mas tienen el mismo numero y misma apuesta"
                + "\n suman puntos de igual manera"
                + " ", "Reglas", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/jugadores.png")));

        while (jugar.equalsIgnoreCase("si")) {

            for (int i = 0; i <= 2; i++) {

     
                //genero cartas para los jugadores
                cartaUs[i] = (int) (Math.random() * 12 + 1);
                m1_c[i] = (int) (Math.random() * 12 + 1);               //12+1
                m2_c[i] = (int) (Math.random() * 12 + 1);

                
                            //cual es la carta mayor
                if (m1_c[i] > cartaMayor[i]) {
                    cartaMayor[i] = m1_c[i];
                    jugadorMayor = "1";
                }

                if (m2_c[i] > cartaMayor[i]) {
                    cartaMayor[i] = m2_c[i];
                    jugadorMayor = "2";
                }

                if (cartaUs[i] > cartaMayor[i]) {
                    cartaMayor[i] = cartaUs[i];
                    jugadorMayor = "Usuario";
                }

                //_________________Jugadores 1 y 2 eligen ganar o perder_______________________
                //jugador 1
                //si la carta es 1 elige perder      opciones : 1 y 3=ganar    2=perder
                if (m1_c[i] == 1) {
                    GanaOpierdeM1 = 2;
                } else {
                    //si la carta es 12 elige ganar
                    if (m1_c[i] == 12) {
                        GanaOpierdeM1 = 1;

                    } else {
                        //si la carta es 10 o 11 hay mas chance de que eliga ganar
                        if (m1_c[i] == 10|| m1_c[i] == 11) {
                            GanaOpierdeM1 = (int) (Math.random() * 3 + 1);
                        } else {

                            //genero gano o pierdo al azar
                            GanaOpierdeM1 = (int) (Math.random() * 2 + 1);
                        }

                    }
                }
                 //Muestro resultados internamente
                System.out.println("");
                System.out.println(" Carta jugador 1= " + m1_c[i]);
                if (GanaOpierdeM1 == 1 || GanaOpierdeM1 == 3) {
                    System.out.println("El jugador 1 eligio ganar esta ronda");
                } else {
                    System.out.println("El jugador 1 eligio perder esta ronda");
                }

                
                
                
                
                
                
                                //jugador 2
                 //si la carta es 1 elige perder        1 y 3=ganar    2=perder
                if (m2_c[i] == 1) {
                    GanaOpierdeM2 = 2;
                } else {
                    //si la carta es 12 elige ganar
                    if (m2_c[i] == 12) {
                        GanaOpierdeM2 = 1;

                    } else {
                        //si la carta  es 10 o 11 hay mas posibilidades de que elija ganar
                        if (m2_c[i] == 10 || m2_c[i] == 11) {
                            GanaOpierdeM2 = (int) (Math.random() * 3 + 1);
                        } else {

                            //genero gano o pierdo al azar
                            GanaOpierdeM2 = (int) (Math.random() * 2 + 1);
                        }

                    }
                }

                //Muestro resultados internamente
                System.out.println("" );
                System.out.println(" Carta Jugador 2= " + m2_c[i]);
                if (GanaOpierdeM2 == 1 ||GanaOpierdeM2 == 3) {
                    System.out.println("El jugador 2 eligio ganar esta ronda");
                } else {
                    System.out.println("El jugador 2 eligio perder esta ronda");
                }

                System.out.println("");
                System.out.println("carta mayor= " + cartaMayor[i] + "    jugador= " + jugadorMayor);

                //_____________________________________Jugador 1____________________________________________________________
                switch (GanaOpierdeM1) {
                    //debe ganar jugador 1 (+6pts
                    case 3:

                    case 1:
                        resj1 = "Ganar";

                        if (m1_c[i] == cartaMayor[i]) {
                            puntosM1 = puntosM1 + 6;
                            cumplioj1 = "Si  +6";

                        } else {

                            puntosM1 = puntosM1 + 0;
                            cumplioj1 = " No";
                        }

                        break;

                    //Debe perder jugador 1 (+5pts)
                    case 2:
                        resj1 = "perder";
                        if (m1_c[i] < cartaMayor[i]) {
                            puntosM1 = puntosM1 + 5;
                            cumplioj1 = " Si  +5";
                        } else {
                            puntosM1 = puntosM1 + 0;
                            cumplioj1 = " No ";
                        }

                        break;
                    default:
                        throw new AssertionError();
                }

                System.out.println(" ");

                //___________________________________Jugador 2 ____________________________________________________
                switch (GanaOpierdeM2) {
                    //debe ganar la maquina 2 (+6pts)
                    case 3:
                        
                    case 1:
                        resj2 = "Ganar";

                        if (m2_c[i] == cartaMayor[i]) {
                            puntosM2 = puntosM2 + 6;
                            cumplioj2 = " Si +6";

                        } else {
                            puntosM2 = puntosM2 + 0;
                            cumplioj2 = " No";
                        }

                        break;

                    //Debe perder la maquina 2 (+5pts)
                    case 2:
                        resj2 = "perder";
                        if (m2_c[i] < cartaMayor[i]) {

                            puntosM2 = puntosM2 + 5;
                            cumplioj2 = " Si  +5";
                        } else {
                            puntosM2 = puntosM2 + 0;
                            cumplioj2 = " No";
 
                        }

                        break;
                    default:
                        throw new AssertionError();
                }
                    //Muestro elecciones ganar o perder de jugador 1 y 2
                JOptionPane.showMessageDialog(null, "", "Jugador 1", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/avatar1" + resj1 + ".png")));
                JOptionPane.showMessageDialog(null, "", "Jugador 2", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/avatar2" + resj2 + ".png")));

                //Usuario
                //**************muestro carta usuario y pregunto************
                JOptionPane.showMessageDialog(null, "", "Su carta es", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/c" + cartaUs[i] + ".jpg")));

                GanaOpierdeUs = (Integer.parseInt(JOptionPane.showInputDialog(null, "Gana o pierde esta ronda?"
                        + "\n"
                        + "\nSu carta es " + cartaUs[i]
                        + "\n"
                        + "\n 1- Gano esta ronda"
                        + "\n 2- Pierdo esta ronda")));

                //***mostrar cartas jugador 1***
                if (GanaOpierdeM1 == 1 || GanaOpierdeM1 == 3) {

                    JOptionPane.showMessageDialog(null, "El jugador 1 dijo que ganaba con esta carta", "carta jugador 1", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/c" + m1_c[i] + ".jpg")));

                } else {

                    JOptionPane.showMessageDialog(null, "El jugador 1 dijo que perdia con esta carta", "Carta jugador 1", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/c" + m1_c[i] + ".jpg")));

                }

                //***mostrar cartas jugador 2***
                if (GanaOpierdeM2 == 1 || GanaOpierdeM2 == 3) {

                    JOptionPane.showMessageDialog(null, "El jugador 2 dijo que ganaba con esta carta", "Carta jugador 2 ", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/c" + m2_c[i] + ".jpg")));

                } else {
                    JOptionPane.showMessageDialog(null, "El jugador 2 dijo que perdia con esta carta", "Carta jugador 2 ", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/c" + m2_c[i] + ".jpg")));

                }

                //____________________________________Usuario_________________________________________________ 
                switch (GanaOpierdeUs) {
                    case 1:             //debe ganar
                        resUs = "ganar";

                        if (cartaUs[i] == cartaMayor[i]) {

                            puntosUs = puntosUs + 6;
                            cumplioUs = "Si +6";
                        } else {

                            puntosUs = puntosUs + 0;
                            cumplioUs = "No";
                        }

                        break;

                    case 2:             //debe perder
                        resUs = "perder";

                        if (cartaUs[i] < cartaMayor[i]) {

                            puntosUs = puntosUs + 5;
                            cumplioUs = "Si  +5";

                        } else {

                            cumplioUs = "No";
                            puntosUs = puntosUs + 0;
                        }

                        break;

                    default:
                        throw new AssertionError();
                }

                System.out.println("Puntos Usuario= " + puntosUs);
                System.out.println("Puntos Jugador 1= " + puntosM1);
                System.out.println("Puntos Jugador 2= " + puntosM2);

                System.out.println("___________________");

                JOptionPane.showMessageDialog(null, "***Resumen ronda*** "
                        + "\n ___________________________________________________________________________________________ "
                        + "\n                                                                                   *****JUGADOR 1*****"
                        + "\n -Carta=    " + "|" + m1_c[i] + "|"
                        + "\n -Eligio " + "*" + resj1 + "*"
                        + "\n -Cumplio= " + cumplioj1
                        + "\n                                                                           Puntos " + puntosM1
                        + "\n ___________________________________________________________________________________________ "
                        + "\n                                                                                   *****JUGADOR 2*****"
                        + "\n -Carta=    " + "|" + m2_c[i] + "|"
                        + "\n -Eligio " + "*" + resj2 + "*"
                        + "\n -Cumplio= " + cumplioj2
                        + "\n                                                                           Puntos " + puntosM2
                        + "\n ___________________________________________________________________________________________ "
                        + "\n                                                                                   *****Su partida*****"
                        + "\n -Carta=    " + "|" + cartaUs[i] + "|"
                        + "\n -Eligio " + "*" + resUs + "*"
                        + "\n -Cumplio= " + cumplioUs
                        + "\n                                                                           Puntos " + puntosUs
                        + "\n ___________________________________________________________________________________________ "
                );
                cartaMayor[i]=0;
            }

            //Ganador
            //jugador 1
            if (puntosM1 > puntosMayor) {
                puntosMayor = puntosM1;
                ganador = 1;

            }
            //jugador 2
            if (puntosM2 > puntosMayor) {
                puntosMayor = puntosM2;
                ganador = 2;

            }
            //Usuario
            if (puntosUs > puntosMayor) {
                puntosMayor = puntosUs;
                ganador = 3;

            }

            System.out.println("ganador= " + ganador);
            
            //muestro ganador

            if (ganador == 3) {
                JOptionPane.showMessageDialog(null, "Ganaste la partida!", "Ganador ", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/ganaste.png")));

            } else {

                if (ganador == 2) {
                    JOptionPane.showMessageDialog(null, "Gano el jugador 2" + "\n", "Ganador ", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/ganador2.png")));

                } else {

                    if (ganador == 1) {
                        JOptionPane.showMessageDialog(null, "Gano el jugador 1!" + "\n " + "\n Suerte a la proxima!", "Ganador ", JOptionPane.PLAIN_MESSAGE, new ImageIcon(Final_c1_v2.class.getResource("/img/ganador1.png")));

                    }
                }
                
            }
            
          //Restauro los puntos a 0 para la proxima partida  
        puntosM1 = 0;
        puntosM2 = 0;
        puntosUs = 0;
            jugar = JOptionPane.showInputDialog(null, "Quiere volver a jugar? Si/no");
        }
       
    }

}

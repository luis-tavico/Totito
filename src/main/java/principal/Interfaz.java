package principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interfaz extends JFrame {

    String[][] tablero = new String[3][3];
    boolean ganadorX = false, ganador0 = false;
    int respuesta = 1;
    int cantidad = 0;
    boolean equis;
    Icon ganador = new ImageIcon("src/main/java/imagenes/copa.png");
    Icon info = new ImageIcon("src/main/java/imagenes/informacion.png");

    public Interfaz(boolean equis) {
        this.equis = equis;
        Image icono = Toolkit.getDefaultToolkit().getImage("src/main/java/imagenes/icono.png");
        setIconImage(icono);
        setSize(550, 550);
        setLocationRelativeTo(null);
        add(new Tablero());
        this.getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        llenarTablero();
        setResizable(false);
    }

    class Tablero extends JPanel {

        private JButton boton1;
        private JButton boton2;
        private JButton boton3;
        private JButton boton4;
        private JButton boton5;
        private JButton boton6;
        private JButton boton7;
        private JButton boton8;
        private JButton boton9;
        boolean inicio = true;
        String posicion1 = "", posicion2 = "", posicion3 = "", posicion4 = "", posicion5 = "", posicion6 = "", posicion7 = "", posicion8 = "", posicion9 = "";
        int posicionx, posiciony;
        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon("src/main/java/imagenes/tablero.png").getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }

        public Tablero() {
            setLayout(null);
            iniciarComponentes();
        }

        public void iniciarComponentes() {
            agregarBoton1();
            agregarBoton2();
            agregarBoton3();
            agregarBoton4();
            agregarBoton5();
            agregarBoton6();
            agregarBoton7();
            agregarBoton8();
            agregarBoton9();
        }

        public void agregarBoton1() {
            boton1 = new JButton();
            boton1.setBounds(40, 60, 80, 80);
            boton1.setBackground(Color.black);
            boton1.setBorderPainted(false);
            boton1.setFocusPainted(false);
            this.add(boton1);
            eventoBoton1Equis();
        }

        public void agregarBoton2() {
            boton2 = new JButton();
            boton2.setBounds(223, 60, 80, 80);
            boton2.setBackground(Color.black);
            boton2.setBorderPainted(false);
            boton2.setFocusPainted(false);
            this.add(boton2);
            eventoBoton2Equis();
        }

        public void agregarBoton3() {
            boton3 = new JButton();
            boton3.setBounds(400, 60, 80, 80);
            boton3.setBackground(Color.black);
            boton3.setBorderPainted(false);
            boton3.setFocusPainted(false);
            this.add(boton3);
            eventoBoton3Equis();
        }

        public void agregarBoton4() {
            boton4 = new JButton();
            boton4.setBounds(40, 215, 80, 80);
            boton4.setBackground(Color.black);
            boton4.setBorderPainted(false);
            boton4.setFocusPainted(false);
            this.add(boton4);
            eventoBoton4Equis();
        }

        public void agregarBoton5() {
            boton5 = new JButton();
            boton5.setBounds(223, 215, 80, 80);
            boton5.setBackground(Color.black);
            boton5.setBorderPainted(false);
            boton5.setFocusPainted(false);
            this.add(boton5);
            eventoBoton5Equis();
        }

        public void agregarBoton6() {
            boton6 = new JButton();
            boton6.setBounds(400, 215, 80, 80);
            boton6.setBackground(Color.black);
            boton6.setBorderPainted(false);
            boton6.setFocusPainted(false);
            this.add(boton6);
            eventoBoton6Equis();
        }

        public void agregarBoton7() {
            boton7 = new JButton();
            boton7.setBounds(40, 380, 80, 80);
            boton7.setBackground(Color.black);
            boton7.setBorderPainted(false);
            boton7.setFocusPainted(false);
            this.add(boton7);
            eventoBoton7Equis();
        }

        public void agregarBoton8() {
            boton8 = new JButton();
            boton8.setBounds(223, 380, 80, 80);
            boton8.setBackground(Color.black);
            boton8.setBorderPainted(false);
            boton8.setFocusPainted(false);
            this.add(boton8);
            eventoBoton8Equis();
        }

        public void agregarBoton9() {
            boton9 = new JButton();
            boton9.setBounds(400, 380, 80, 80);
            boton9.setBackground(Color.black);
            boton9.setBorderPainted(false);
            boton9.setFocusPainted(false);
            this.add(boton9);
            eventoBoton9Equis();
        }

        public void eventoBoton1Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion1 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
                            posicion1 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton1.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
                            posicion1 = "o";
                            equis = true;
                        }
                        posicionx = 0;
                        posiciony = 0;
                        llenarTablero(posicionx, posiciony, posicion1);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }
                }
            };

            boton1.addActionListener(evento);
        }

        public void eventoBoton2Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion2 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
                            posicion2 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
                            posicion2 = "o";
                            equis = true;
                        }
                        posicionx = 0;
                        posiciony = 1;
                        llenarTablero(posicionx, posiciony, posicion2);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton2.addActionListener(evento);
        }

        public void eventoBoton3Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion3 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
                            posicion3 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton3.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
                            posicion3 = "o";
                            equis = true;
                        }
                        posicionx = 0;
                        posiciony = 2;
                        llenarTablero(posicionx, posiciony, posicion3);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton3.addActionListener(evento);
        }

        public void eventoBoton4Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion4 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
                            posicion4 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton4.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
                            posicion4 = "o";
                            equis = true;
                        }
                        posicionx = 1;
                        posiciony = 0;
                        llenarTablero(posicionx, posiciony, posicion4);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton4.addActionListener(evento);
        }

        public void eventoBoton5Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion5 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
                            posicion5 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton5.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
                            posicion5 = "o";
                            equis = true;
                        }
                        posicionx = 1;
                        posiciony = 1;
                        llenarTablero(posicionx, posiciony, posicion5);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton5.addActionListener(evento);
        }

        public void eventoBoton6Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion6 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton6.getWidth(), boton6.getHeight(), Image.SCALE_SMOOTH)));
                            posicion6 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton6.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton6.getWidth(), boton6.getHeight(), Image.SCALE_SMOOTH)));
                            posicion6 = "o";
                            equis = true;
                        }
                        posicionx = 1;
                        posiciony = 2;
                        llenarTablero(posicionx, posiciony, posicion6);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton6.addActionListener(evento);
        }

        public void eventoBoton7Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion7 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton7.getWidth(), boton7.getHeight(), Image.SCALE_SMOOTH)));
                            posicion7 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton7.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton7.getWidth(), boton7.getHeight(), Image.SCALE_SMOOTH)));
                            posicion7 = "o";
                            equis = true;
                        }
                        posicionx = 2;
                        posiciony = 0;
                        llenarTablero(posicionx, posiciony, posicion7);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }

                }
            };

            boton7.addActionListener(evento);
        }

        public void eventoBoton8Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion8 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton8.getWidth(), boton8.getHeight(), Image.SCALE_SMOOTH)));
                            posicion8 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton8.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton8.getWidth(), boton8.getHeight(), Image.SCALE_SMOOTH)));
                            posicion8 = "o";
                            equis = true;
                        }
                        posicionx = 2;
                        posiciony = 1;
                        llenarTablero(posicionx, posiciony, posicion8);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }
                }
            };

            boton8.addActionListener(evento);
        }

        public void eventoBoton9Equis() {

            ActionListener evento = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posicion9 == "") {
                        if (equis == true) {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/equis.jpg");
                            boton9.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton9.getWidth(), boton9.getHeight(), Image.SCALE_SMOOTH)));
                            posicion9 = "x";
                            equis = false;
                        } else {
                            ImageIcon imagen = new ImageIcon("src/main/java/imagenes/circulo.png");
                            boton9.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(boton9.getWidth(), boton9.getHeight(), Image.SCALE_SMOOTH)));
                            posicion9 = "o";
                            equis = true;
                        }
                        posicionx = 2;
                        posiciony = 2;
                        llenarTablero(posicionx, posiciony, posicion9);
                        verificarX();
                        verificar0();
                        if ((ganadorX == true) || (ganador0 == true)) {
                            confirmacionMensaje();
                        } else if ((ganadorX == false) && (ganador0 == false) && cantidad == 18) {
                            empate();
                            confirmacionMensaje();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "¡La casilla esta llena!");
                    }
                }
            };

            boton9.addActionListener(evento);
        }

    }

    public void llenarTablero() {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                tablero[i][j] = "";
            }
        }
    }

    public void llenarTablero(int x, int y, String icono) {
        tablero[x][y] = icono;
    }

    public void verificarX() {
        if (tablero[0][0].equals("x") && tablero[0][1].equals("x") && tablero[0][2].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[1][0].equals("x") && tablero[1][1].equals("x") && tablero[1][2].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[2][0].equals("x") && tablero[2][1].equals("x") && tablero[2][2].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[0][0].equals("x") && tablero[1][0].equals("x") && tablero[2][0].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[0][1].equals("x") && tablero[1][1].equals("x") && tablero[2][1].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[0][2].equals("x") && tablero[1][2].equals("x") && tablero[2][2].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[0][0].equals("x") && tablero[1][1].equals("x") && tablero[2][2].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else if (tablero[0][2].equals("x") && tablero[1][1].equals("x") && tablero[2][0].equals("x")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: X\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganadorX = true;
        } else {
            ganadorX = false;
            cantidad++;
        }
    }

    public void verificar0() {
        if (tablero[0][0].equals("o") && tablero[0][1].equals("o") && tablero[0][2].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[1][0].equals("o") && tablero[1][1].equals("o") && tablero[1][2].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[2][0].equals("o") && tablero[2][1].equals("o") && tablero[2][2].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[0][0].equals("o") && tablero[1][0].equals("o") && tablero[2][0].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[0][1].equals("o") && tablero[1][1].equals("o") && tablero[2][1].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[0][2].equals("o") && tablero[1][2].equals("o") && tablero[2][2].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[0][0].equals("o") && tablero[1][1].equals("o") && tablero[2][2].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else if (tablero[0][2].equals("o") && tablero[1][1].equals("o") && tablero[2][0].equals("o")) {
            respuesta = JOptionPane.showConfirmDialog(null, "Ganador: O\n¿Desea Jugar de Nuevo?", "¡TOTITO!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ganador);
            ganador0 = true;
        } else {
            ganador0 = false;
            cantidad++;
        }
    }

    public void empate() {
        respuesta = JOptionPane.showConfirmDialog(null, "¿Desea Jugar de Nuevo?", "¡EMPATE!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, info);
    }

    public void confirmacionMensaje() {
        if (respuesta == 0) {
            dispose();
            Juego nuevoJuego = new Juego();
            nuevoJuego.setVisible(true);

        } else {
            System.exit(0);
        }
    }

}

package sesion4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PythagorasTree extends JPanel {
    private int profundidad;
    
    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad;
        setPreferredSize(new Dimension(800, 800));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.setColor(Color.GREEN);
        trazaArbol(g2d, 350, 600, 100, -90, profundidad); 
    }
    
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return;
        int x2 = x + (int) (lado * Math.cos(toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(toRadians(angulo)));
        g.drawLine(x, y, x2, y2);
        int nuevoLado = (int) (lado * 0.7);
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1);
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1);
    }

    private double toRadians(double angulo) {
        return Math.toRadians(angulo);
    }
    
    public static void main(String[] args) {
    	/*
        JFrame frame6 = new JFrame("Arbol de Pitagoras de 6 niveles");  //ventana
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //cierre
        frame6.setSize(800, 800);  //tamaño ventana
        PythagorasTree panel = new PythagorasTree(6);  //recursividad
        frame6.add(panel); //dibuja
        frame6.setVisible(true);
        */
    	
    	/*
        JFrame frame8 = new JFrame("Arbol de Pitagoras de 8 niveles");  //ventana
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //cierre
        frame8.setSize(650, 650);  //tamaño ventana
        PythagorasTree panel = new PythagorasTree(8);  //recursividad
        frame8.add(panel); //dibuja
        frame8.setVisible(true);
        */
        
        JFrame frame10 = new JFrame("Arbol de Pitagoras de 10 niveles");  //ventana
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //cierre
        frame10.setSize(800, 800);  //tamaño ventana
        PythagorasTree panel = new PythagorasTree(10);  //recursividad
        frame10.add(panel); //dibuja
        frame10.setVisible(true);
        
    }

}

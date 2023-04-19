package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationFrame extends JFrame {
    private JFrame frame;

    private JLabel lblClients;
    private JTextField txtClients;
    private JLabel lblQueues;
    private JTextField txtQueues;
    private JLabel lblSimulationInterval;
    private JTextField txtSimulationInterval;

    private JLabel lblMinArrivalTime;
    private JTextField txtMinArrivalTime;
    private JLabel lblMaxArrivalTime;
    private JTextField txtMaxArrivalTime;

    private JLabel lblMinServiceTime;
    private JTextField txtMinServiceTime;
    private JLabel lblMaxServiceTime;
    private JTextField txtMaxServiceTime;
    private JButton btnSubmit;

    public SimulationFrame() {

        frame = new JFrame("Input Data");

        lblClients = new JLabel("Number of clients (N):");
        txtClients = new JTextField(10);
        lblQueues = new JLabel("Number of queues (Q):");
        txtQueues = new JTextField(10);
        lblSimulationInterval = new JLabel("Simulation interval (MAX):");
        txtSimulationInterval = new JTextField(10);
        lblMinArrivalTime = new JLabel("Minimum arrival time:");
        txtMinArrivalTime = new JTextField(10);
        lblMaxArrivalTime = new JLabel("Maximum arrival time:");
        txtMaxArrivalTime = new JTextField(10);
        lblMinServiceTime = new JLabel("Minimum service time:");
        txtMinServiceTime = new JTextField(10);
        lblMaxServiceTime = new JLabel("Maximum service time:");
        txtMaxServiceTime = new JTextField(10);
       // btnSubmit = new JButton("Submit");


        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(lblClients);
        panel.add(txtClients);
        panel.add(lblQueues);
        panel.add(txtQueues);
        panel.add(lblSimulationInterval);
        panel.add(txtSimulationInterval);
        panel.add(lblMinArrivalTime);
        panel.add(txtMinArrivalTime);
        panel.add(lblMaxArrivalTime);
        panel.add(txtMaxArrivalTime);
        panel.add(lblMinServiceTime);
        panel.add(txtMinServiceTime);
        panel.add(lblMaxServiceTime);
        panel.add(txtMaxServiceTime);
       // panel.add(btnSubmit);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 200);
        frame.setLocation(700, 300);




        // Set up the Submit button
//        btnSubmit.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                //submit();
//            }
//        });
    }

//    public void run() {
//        setVisible(true);
//    }

    //    public void submit() {
//        int numberOfClients = getNumberOfClients();
//        int numberOfQueues = getNumberOfQueues();
//        int simulationInterval = getSimulationInterval();
//        int minArrivalTime = getMinArrivalTime();
//        int maxArrivalTime = getMaxArrivalTime();
//        int minServiceTime = getMin
    }
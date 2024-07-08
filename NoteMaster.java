import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteMaster extends JFrame {
    private JTextField taskTextField;
    private JTextField dateTextField;
    private JButton addButton;
    private JButton removeButton;
    private JButton editButton;
    private JButton viewButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public NoteMaster() {
        // Create GUI components
        taskTextField = new JTextField(20);
        dateTextField = new JTextField(10);
        addButton = new JButton("Add Task");
        removeButton = new JButton("Remove Task");
        editButton = new JButton("Edit Task");
        viewButton = new JButton("View All Tasks");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Add action listener to add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskTextField.getText();
                String date = dateTextField.getText();
                if (!task.isEmpty() && isValidDate(date)) {
                    listModel.addElement(task + " - " + date);
                    taskTextField.setText("");
                    dateTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid task and date (yyyy-MM-dd).");
                }
            }
        });

        // Add action listener to remove button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                }
            }
        });

        // Add action listener to edit button
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedTask = listModel.get(selectedIndex);
                    String[] parts = selectedTask.split(" - ");
                    String newTask = JOptionPane.showInputDialog("Edit Task", parts[0]);
                    String newDate = JOptionPane.showInputDialog("Edit Date (yyyy-MM-dd)", parts[1]);
                    if (newTask != null && !newTask.isEmpty() && isValidDate(newDate)) {
                        listModel.set(selectedIndex, newTask + " - " + newDate);
                    }
                }
            }
        });

        // Add action listener to view button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder tasks = new StringBuilder("All Tasks:\n");
                for (int i = 0; i < listModel.size(); i++) {
                    tasks.append(listModel.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(null, tasks.toString());
            }
        });

        // Set up the layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Task:"));
        add(taskTextField);
        add(new JLabel("Date (yyyy-MM-dd):"));
        add(dateTextField);
        add(addButton);
        add(removeButton);
        add(editButton);
        add(viewButton);
        add(new JScrollPane(taskList));

        // Set up the frame
        setTitle("NoteMaster");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private boolean isValidDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            format.setLenient(false);
            format.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new NoteMaster();
    }
}

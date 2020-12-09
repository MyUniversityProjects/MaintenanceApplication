package root.screens.manageusers;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class ButtonColumn {
    private ButtonColumnActionListener al;

    public ButtonColumn(TableColumn tc, boolean hideHeaderValue) {
        tc.setCellRenderer(new Renderer());
        tc.setCellEditor(new Editor());
        if (hideHeaderValue)
            tc.setHeaderValue("");
    }
    
    public ButtonColumn(TableColumn tc, boolean hideHeaderValue, int width) {
        this(tc, hideHeaderValue);
        tc.setMinWidth(width);
        tc.setMaxWidth(width);
    }
    
    public ButtonColumn(TableColumn tc) {
        this(tc, false);
    }
    
    public void setActionListener(ButtonColumnActionListener al) {
        this.al = al;
    }

    private class Renderer implements TableCellRenderer {
        private final JButton btn;

        public Renderer() {
            btn = new JButton();
            btn.setOpaque(true);
        }
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            btn.setText((value == null) ? "" : value.toString());
            return btn;
        }
    }

    private class Editor extends DefaultCellEditor {
        private String label;
        private boolean isPushed;
        private int editingRow;
        private final JButton btn;
        
        public Editor() {
            super(new JCheckBox());
            btn = new JButton();
            btn.setOpaque(true);
            btn.addActionListener((e) -> {
                fireEditingStopped();
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            btn.setText(label);
            editingRow = row;
            isPushed = true;
            return btn;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed && al != null) {
                al.actionPerformed(editingRow);
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
}

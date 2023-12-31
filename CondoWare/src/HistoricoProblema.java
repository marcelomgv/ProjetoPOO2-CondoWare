package CondoWare2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.Date;

public class HistoricoProblema extends javax.swing.JFrame {

    /**
     * Creates new form HistoricoProblema
     */
    private HistoricoProblema() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private static HistoricoProblema historicoProblemaUnic;
    public static HistoricoProblema getHistoricoProblemaUnicUnic(){
        if(historicoProblemaUnic == null){
            historicoProblemaUnic = new HistoricoProblema();
        }
        return historicoProblemaUnic;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabHistorico = new javax.swing.JTable();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Todos os Problemas Registrados");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tabHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Bloco", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabHistoricoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabHistorico);

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btVoltar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        listarAll();
    }//GEN-LAST:event_formWindowActivated

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void tabHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabHistoricoMouseClicked
        mostrarLinha();
    }//GEN-LAST:event_tabHistoricoMouseClicked
    
    public void mostrarLinha(){
        int row = tabHistorico.getSelectedRow();
        String desc = (String) tabHistorico.getValueAt(row, 0);
        String bloco = (String) tabHistorico.getValueAt(row,1);
        Date data = (Date) tabHistorico.getValueAt(row,2);
        JOptionPane.showMessageDialog(
                        null,
                        "descrição: " +desc+
                        "\nBloco: " +bloco+
                        "\nData: " +data,
                        "Problema",
                        1);
    }
    public void listarAll() {
        Bancos.getBancos().getBdProblemas().clear();
        Conexao.getConexao().atualizaBancoProblemas();
        DefaultTableModel tabModel = (DefaultTableModel) tabHistorico.getModel();
        int posLin = 0;
        tabModel.setRowCount(posLin);
        for(Problemas p: Bancos.getBancos().getBdProblemas()) {
            tabModel.insertRow(posLin, new Object[]{p.getDescricao(),
                                                       p.getBloco(),
                                                       p.getData()});
            posLin++;
        }
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabHistorico;
    // End of variables declaration//GEN-END:variables
}

package igu;

import logica.ControladoraLogica;
import logica.entidades.Usuario;

public class LoginHome extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LoginHome.class.getName());

    private ControladoraLogica logicControl;

    public LoginHome() {
        initComponents();
        logicControl = new ControladoraLogica();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        separator1 = new javax.swing.JSeparator();
        label_user = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        separator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_area = new javax.swing.JTextArea();
        btn_limpiar = new javax.swing.JButton();
        btn_ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        label_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_titulo.setText("Login");

        label_user.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_user.setText("Usuario:");

        label_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_password.setText("Contraseña:");

        txt_area.setEditable(false);
        txt_area.setColumns(20);
        txt_area.setRows(5);
        jScrollPane1.setViewportView(txt_area);

        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(this::btn_limpiarActionPerformed);

        btn_ingresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_ingresar.setText("Ingresar");
        btn_ingresar.addActionListener(this::btn_ingresarActionPerformed);

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(separator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_password)
                            .addComponent(label_user))
                        .addGap(18, 18, 18)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password)
                            .addComponent(txt_user)))
                    .addComponent(separator2))
                .addContainerGap())
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btn_limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btn_ingresar)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_titulo)
                .addGap(129, 129, 129))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_user)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_ingresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_user.setText("");
        txt_password.setText("");
        txt_area.setText("");
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        String user;
        String pass;

        user = txt_user.getText();
        pass = String.valueOf(txt_password.getPassword());

        String mensaje = "";

        if (!user.isBlank()) {
            if (!pass.isBlank()) {
                Usuario usr = logicControl.validarUserPass(user, pass);
                if(usr!=null){
                                        
                    if(usr.getRol().getNombreRol().toUpperCase().equals("ADMIN")){
                        mensaje = "Bienvenido Admin";
                        PrincipalAdm pAdmin = new PrincipalAdm(logicControl, usr);
                        pAdmin.setVisible(true);
                        pAdmin.setLocationRelativeTo(null);
                        pAdmin.setResizable(false);
                        this.dispose();
                    }
                    if(usr.getRol().getNombreRol().toUpperCase().equals("USER")){
                        mensaje = "Bienvenido usuario";
                        PrincipalUsuario pUser = new PrincipalUsuario(logicControl, usr);
                        pUser.setVisible(true);
                        pUser.setLocationRelativeTo(null);
                        pUser.setResizable(false);
                        this.dispose();
                    }
                }else{
                    mensaje = "Usuario y/o contraseña invalidos";
                }
            } else {
                mensaje = "El campo contraseña no puede estar en blanco";
            }
        } else {
            mensaje = "El campo usuario no puede estar en blanco";
        }

        txt_area.setText(mensaje);
    }//GEN-LAST:event_btn_ingresarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_user;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JTextArea txt_area;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}

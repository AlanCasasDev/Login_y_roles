/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package igu;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logica.ControladoraLogica;
import logica.entidades.Rol;
import logica.entidades.Usuario;

public class AltaUsuario extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AltaUsuario.class.getName());

    private ControladoraLogica logicControl;
    private Usuario user;

    public AltaUsuario(ControladoraLogica logicControl, Usuario user) {
        initComponents();
        this.logicControl = logicControl;
        this.user = user;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        label_usuario_conectado.setText("Adm: " + user.getUser());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        label_usuario = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        label_rol = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        combo_rol = new javax.swing.JComboBox<>();
        separador = new javax.swing.JSeparator();
        btn_volver = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        label_usuario_conectado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        label_titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        label_titulo.setText("Alta de usuarios");

        label_usuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_usuario.setText("Nombre de Usuario:");

        label_password.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_password.setText("Contraseña:");

        label_rol.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        label_rol.setText("Tipo de Rol:");

        txt_usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        combo_rol.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btn_volver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(this::btn_volverActionPerformed);

        btn_limpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(this::btn_limpiarActionPerformed);

        btn_registrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_registrar.setText("Registrar Usuario");
        btn_registrar.addActionListener(this::btn_registrarActionPerformed);

        label_usuario_conectado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_usuario_conectado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_usuario_conectado.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_volver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(btn_limpiar)
                        .addGap(82, 82, 82)
                        .addComponent(btn_registrar)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_rol)
                            .addComponent(label_password)
                            .addComponent(label_usuario))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_usuario)
                            .addComponent(combo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_titulo)
                                .addGap(124, 124, 124)
                                .addComponent(label_usuario_conectado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(separador))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_titulo)
                    .addComponent(label_usuario_conectado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_usuario)
                    .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_rol)
                    .addComponent(combo_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_volver)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_registrar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        PrincipalAdm principalAdm = new PrincipalAdm(logicControl, user);
        principalAdm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<Rol> listaRoles = logicControl.traerRoles();

        if (listaRoles != null) {
            for (Rol rol : listaRoles) {
                combo_rol.addItem(rol.getNombreRol());
            }
        }

    }//GEN-LAST:event_formWindowOpened

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed

        if (validarFormulario()) {
            if (!confirmarAccion("¿Desea registrar el nuevo usuario?", "Confirmación")) {
                return;
            }

            String user = txt_usuario.getText();
            String pass = String.valueOf(txt_password.getPassword());
            String rol = String.valueOf(combo_rol.getSelectedItem());

            if (logicControl.crearUsuario(user, pass, rol)) {
                //metodo de mensaje de usuario creado correctamente                
                mostrarMensaje("Se realizo el alta de usuario correctamente", "info", "Titulo");
                //borra le formulario luego del guardado
                btn_limpiarActionPerformed(evt);
                //regresa a la tabla de mostrar
                btn_volverActionPerformed(evt);
            } else {
                //metodo de error en la creacion del usuario
                mostrarMensaje("ERROR: No se pudo guardar el usuario", "error", "Titulo");
            }

        } else {
            mostrarMensaje("Error: Se debe completar todos los campos para registrar un usuario", "error", "Campos incompletos");
        }


    }//GEN-LAST:event_btn_registrarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        txt_usuario.setText("");
        txt_password.setText("");
        combo_rol.setSelectedIndex(0);
    }//GEN-LAST:event_btn_limpiarActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JComboBox<String> combo_rol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_rol;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_usuario;
    private javax.swing.JLabel label_usuario_conectado;
    private javax.swing.JSeparator separador;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    private boolean validarFormulario() {
        /*TODO metodo para llamar en guardar*/
        if (txt_usuario.getText().isBlank() || String.valueOf(txt_password.getPassword()).isBlank()) {
            return false;
        } else {
            return true;
        }
    }

    private void mostrarMensaje(String mensaje, String tipo, String titulo) {
        JOptionPane optionPane = new JOptionPane(mensaje);
        if (tipo.equals("info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (tipo.equals("error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }

        JDialog dialog = optionPane.createDialog(titulo);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /*AVISO DE CONFIRMACION (usando en boton guardar -modificar-)*/
    private boolean confirmarAccion(String mensaje, String titulo) {
        int opcion = JOptionPane.showConfirmDialog(
                this,
                mensaje,
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        return opcion == JOptionPane.YES_OPTION;
    }

}

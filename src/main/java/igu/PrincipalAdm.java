package igu;

import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.ControladoraLogica;
import logica.entidades.Usuario;

public class PrincipalAdm extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrincipalAdm.class.getName());

    private ControladoraLogica logicControl;
    private Usuario user;

    public PrincipalAdm(ControladoraLogica logicControl, Usuario user) {
        initComponents();
        this.logicControl = logicControl;
        this.user = user;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        label_titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_principal = new javax.swing.JTable();
        btn_crear_usuario = new javax.swing.JButton();
        btn_editar_usuario = new javax.swing.JButton();
        btn_borrar_usuario = new javax.swing.JButton();
        btn_actualizar_tabla = new javax.swing.JButton();
        btn_cerrar_sesion = new javax.swing.JButton();
        label_usuario_conectado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        label_titulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        label_titulo.setText("Sistema Administrador de Usuarios");

        tabla_principal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_principal);

        btn_crear_usuario.setText("Crear Nuevo Usuario");
        btn_crear_usuario.addActionListener(this::btn_crear_usuarioActionPerformed);

        btn_editar_usuario.setText("Editar Usuario");
        btn_editar_usuario.addActionListener(this::btn_editar_usuarioActionPerformed);

        btn_borrar_usuario.setText("Borrar Usuario");
        btn_borrar_usuario.addActionListener(this::btn_borrar_usuarioActionPerformed);

        btn_actualizar_tabla.setText("Actualizar Tabla");
        btn_actualizar_tabla.addActionListener(this::btn_actualizar_tablaActionPerformed);

        btn_cerrar_sesion.setText("Cerrar Sesion");
        btn_cerrar_sesion.addActionListener(this::btn_cerrar_sesionActionPerformed);

        label_usuario_conectado.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        label_usuario_conectado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_usuario_conectado.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_titulo))
                .addGap(18, 18, 18)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(label_usuario_conectado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_crear_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_editar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_borrar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar_tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cerrar_sesion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE))))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(label_titulo))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_usuario_conectado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addComponent(btn_crear_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(btn_editar_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(btn_borrar_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(btn_actualizar_tabla)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cerrar_sesion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                .addContainerGap())
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

    private void btn_editar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editar_usuarioActionPerformed
        if (tabla_principal.getRowCount() > 0) { //Que haya al menos 1 registro
            if (tabla_principal.getSelectedRow() != -1) { //Que se haya seleccionado al menos 1 registro

                //obtengo la id
                Long id = Long.parseLong(String.valueOf(tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 0)));


                EditarUsuario editarUsuario = new EditarUsuario(logicControl, user, id);
                editarUsuario.setVisible(true);
                editarUsuario.setLocationRelativeTo(null);
                this.dispose();

            } else {
                mostrarMensaje("No se ha seleccionado ningun registro", "error", "Error al seleccionar");
            }
        } else {
            mostrarMensaje("No hay nada que editar en la tabla", "error", "Error al editar");
        }
    }//GEN-LAST:event_btn_editar_usuarioActionPerformed

    private void btn_borrar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrar_usuarioActionPerformed
        if (tabla_principal.getRowCount() > 0) { //Que haya al menos 1 registro
            if (tabla_principal.getSelectedRow() != -1) { //Que se haya seleccionado al menos 1 registro

                //obtengo la id
                Long id = Long.parseLong(String.valueOf(tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 0)));

                //Impido que el adm se borre asi mismo
                if (id != user.getId()) {
                    /*Aviso de confiamacion*/
                    if (!confirmarAccion("¿Desea borrar el registro con id: " + id + "?"
                            + "\nUsuario: " + tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 1)
                            + "\nContraseña: " + tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 2)
                            + "\nRol: " + tabla_principal.getValueAt(tabla_principal.getSelectedRow(), 3),
                            "Confirmación")) {
                        return;
                    }

                    if (logicControl.borrarUsuario(id)) {
                        mostrarMensaje("Se borro un registro", "info", "Borrado de usuario"); //JOpane
                        cargarTabla(); //Se vuelve a cargar la tabla para actualizar los cambios
                        tabla_principal.clearSelection(); //OPCIONAL Evita que quede una fila “fantasma” seleccionada
                    } else {
                        mostrarMensaje("Error: No se pudo borrar el registro ", "error", "Borrado de usuario");
                        tabla_principal.clearSelection(); //OPCIONAL Evita que quede una fila “fantasma” seleccionada
                    }

                } else {
                    mostrarMensaje("No puede borrar su propio usuario", "error", "Borrado de usuario");
                }

            } else {
                mostrarMensaje("No se ha seleccionado ningun registro", "error", "Error al seleccionar");
            }
        } else {
            mostrarMensaje("No hay nada que eliminar en la tabla", "error", "Error al eliminar");
        }
    }//GEN-LAST:event_btn_borrar_usuarioActionPerformed

    private void btn_actualizar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_tablaActionPerformed
        this.cargarTabla();
    }//GEN-LAST:event_btn_actualizar_tablaActionPerformed

    private void btn_cerrar_sesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrar_sesionActionPerformed
        if (!confirmarAccion("¿Desea cerrar sesion?", "Salir")) {
            return;
        }

        LoginHome home = new LoginHome();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cerrar_sesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        label_usuario_conectado.setText("Adm: " + user.getUser());
        cargarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btn_crear_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crear_usuarioActionPerformed
        AltaUsuario altaUser = new AltaUsuario(logicControl, user);
        altaUser.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_crear_usuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_tabla;
    private javax.swing.JButton btn_borrar_usuario;
    private javax.swing.JButton btn_cerrar_sesion;
    private javax.swing.JButton btn_crear_usuario;
    private javax.swing.JButton btn_editar_usuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_titulo;
    private javax.swing.JLabel label_usuario_conectado;
    private javax.swing.JPanel panel_principal;
    private javax.swing.JTable tabla_principal;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        //definir el modelo que queremos para la tabla
        DefaultTableModel model_tabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int fila, int colum) {
                return false; //La tabla NO ES MODIFICABLE
            }
        };

        //Nombre de los titulos de las columnas
        String titulos[] = {"ID", "Nombre", "Contraseña", "Rol"};
        model_tabla.setColumnIdentifiers(titulos); //Crea las columnas con los nombres del array

        //Seteamos el modelo al elemento tabla. (Configuramos como sera la tabla)
        tabla_principal.setModel(model_tabla);

        // Centrar contenido
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < tabla_principal.getColumnCount(); i++) {
            tabla_principal.getColumnModel().getColumn(i).setCellRenderer(centrado);
        } //Fin del centrado de contenido        

        //Carga de los datos desde la BD a la tabla
        //Trae desde la BD a una lista
        List<Usuario> listaUsuarios = logicControl.traerUsuarios();
        //Si la lista no esta vacia, pasa cada mascota a un objeto
        if (listaUsuarios != null) {
            for (Usuario usuario : listaUsuarios) {
                Object[] objeto = {
                    usuario.getId(),
                    usuario.getUser(),
                    usuario.getPassword(),
                    usuario.getRol().getNombreRol()

                };
                //agrega el objeto a la fila de la tabla en el mismo orden de atributos que se fijo arriba
                model_tabla.addRow(objeto);
            }
        }
    }

    /*Metodo para mensajes de JOptionPane*/
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

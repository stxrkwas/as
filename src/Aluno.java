/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Malu Passo Silva
 */
import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.SQLException;

public class Aluno extends javax.swing.JFrame {

    Conexao con_cliente;
    
    public Aluno() {
        
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executaSQL("select * from aluno order by IdAluno");
        
        initComponents();
        
        aluno.setAutoCreateRowSorter(true);
        preencherTabela();
        posicionarRegistro();
        
    }
    
    public void preencherTabela(){
        
        aluno.getColumnModel().getColumn(0).setPreferredWidth(10);
        aluno.getColumnModel().getColumn(1).setPreferredWidth(100);
        aluno.getColumnModel().getColumn(2).setPreferredWidth(60);
        aluno.getColumnModel().getColumn(3).setPreferredWidth(14);
        aluno.getColumnModel().getColumn(4).setPreferredWidth(100);
        aluno.getColumnModel().getColumn(5).setPreferredWidth(80);
        aluno.getColumnModel().getColumn(6).setPreferredWidth(50);
        
        DefaultTableModel modelo = (DefaultTableModel) aluno.getModel();
        modelo.setNumRows(0);
        
        try{
            
            con_cliente.resultset.beforeFirst();
            
            while(con_cliente.resultset.next()){
                
                modelo.addRow(new Object[]{
                    
                    con_cliente.resultset.getString("IdAluno"), con_cliente.resultset.getString("NomeAluno"), con_cliente.resultset.getString("DataNasc"),con_cliente.resultset.getString("Genero"), con_cliente.resultset.getString("Endereco"), con_cliente.resultset.getString("Telefone"), con_cliente.resultset.getString("DataMatricula")
                });
                       
            }
              
        }
          
        catch(SQLException erro){
                
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!! :\n" + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);    
                
        }   
            
    }
    
    public void posicionarRegistro(){
        
        try{
            
            con_cliente.resultset.first();
            mostrar_Dados();
            
        }
        
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Não foi possível posicionar no primeiro registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public void mostrar_Dados(){
        
        try{
            
            txtCod.setText(con_cliente.resultset.getString("IdAluno"));
            txtNome.setText(con_cliente.resultset.getString("NomeAluno"));
            txtDataNasc.setText(con_cliente.resultset.getString("DataNasc"));
            txtGen.setText(con_cliente.resultset.getString("Genero"));
            txtEndereco.setText(con_cliente.resultset.getString("Endereco"));
            txtTel.setText(con_cliente.resultset.getString("Telefone"));
            txtDataMat.setText(con_cliente.resultset.getString("DataMatricula"));
            
        }
        
        catch(SQLException erro){
            
            JOptionPane.showMessageDialog(null, "Não localizou dados: "+erro, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        alunoimg_lbl = new javax.swing.JLabel();
        nome_lbl = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        gen_lbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtmat_lbl = new javax.swing.JLabel();
        txtGen = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtDataMat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        aluno = new javax.swing.JTable();
        backbtn = new javax.swing.JLabel();
        PrimeiroRegistro = new javax.swing.JLabel();
        VoltarUmRegistro = new javax.swing.JLabel();
        ProximoRegistro = new javax.swing.JLabel();
        UltimoRegistro = new javax.swing.JLabel();
        create_btn = new javax.swing.JLabel();
        editar_btn = new javax.swing.JLabel();
        save_btn = new javax.swing.JLabel();
        delete_btn = new javax.swing.JLabel();
        cod_lbl = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        txtTel = new javax.swing.JFormattedTextField();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(850, 820));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Gadugi", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Aluno");

        alunoimg_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/student (4).png"))); // NOI18N

        nome_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        nome_lbl.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        txtNome.setToolTipText("Inserir o nome");

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Data de nascimento:");

        gen_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        gen_lbl.setText("Gênero:");

        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        jLabel5.setText("Telefone:");

        dtmat_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        dtmat_lbl.setText("Data de matrícula:");

        txtGen.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        txtGen.setToolTipText("Inserir o gênero ");

        txtEndereco.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        txtEndereco.setToolTipText("Inserir o endereço");

        txtDataMat.setFont(new java.awt.Font("Gadugi", 0, 12)); // NOI18N
        txtDataMat.setToolTipText("Inserir a data de matrícula");

        aluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Data Nascimento", "Gênero", "Endereço", "Telefone", "Data Matrícula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        aluno.setToolTipText("Tabela com os alunos registrados");
        aluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunoMouseClicked(evt);
            }
        });
        aluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                alunoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(aluno);

        backbtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Fasticon-Essential-Toolbar-Undo.32.png"))); // NOI18N
        backbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backbtnMouseClicked(evt);
            }
        });

        PrimeiroRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-rew.48.png"))); // NOI18N
        PrimeiroRegistro.setToolTipText("Ir para o primeiro registro");
        PrimeiroRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrimeiroRegistroMouseClicked(evt);
            }
        });

        VoltarUmRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        VoltarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-back.48.png"))); // NOI18N
        VoltarUmRegistro.setToolTipText("Voltar um registro");
        VoltarUmRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VoltarUmRegistroMouseClicked(evt);
            }
        });

        ProximoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProximoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-fordward.48.png"))); // NOI18N
        ProximoRegistro.setToolTipText("Avançar um registro");
        ProximoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProximoRegistroMouseClicked(evt);
            }
        });

        UltimoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Player-ff.48.png"))); // NOI18N
        UltimoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UltimoRegistroMouseClicked(evt);
            }
        });

        create_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Badge-plus.48.png"))); // NOI18N
        create_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_btnMouseClicked(evt);
            }
        });

        editar_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editar_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Pencil-yellow.48.png"))); // NOI18N
        editar_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editar_btnMouseClicked(evt);
            }
        });

        save_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Emey87-Trainee-Floppy-disk.48.png"))); // NOI18N
        save_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_btnMouseClicked(evt);
            }
        });

        delete_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Creative-Freedom-Free-Funktional-02-Recycle.48.png"))); // NOI18N
        delete_btn.setToolTipText("Deletar registro");
        delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete_btnMouseClicked(evt);
            }
        });

        cod_lbl.setFont(new java.awt.Font("Gadugi", 1, 16)); // NOI18N
        cod_lbl.setText("Código: ");

        try {
            txtTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(alunoimg_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTel))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(dtmat_lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataMat, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(gen_lbl)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGen, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(create_btn)
                                    .addGap(18, 18, 18)
                                    .addComponent(editar_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(save_btn)
                                    .addGap(18, 18, 18)
                                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNasc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nome_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cod_lbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCod)))
                        .addGap(0, 46, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PrimeiroRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(VoltarUmRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(ProximoRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(UltimoRegistro))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cod_lbl)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nome_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gen_lbl)
                            .addComponent(txtGen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(alunoimg_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtmat_lbl)
                    .addComponent(txtDataMat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(delete_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editar_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(save_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(create_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(UltimoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(ProximoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(VoltarUmRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(PrimeiroRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void delete_btnMouseClicked(java.awt.event.MouseEvent evt) {                                        

        String sql = "";

        try{

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ", "Confirmar exclusão", JOptionPane.YES_NO_OPTION, 3);

            if(resposta == 0){

                sql = "delete from aluno where IdAluno = " + txtCod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);

                if(excluir == 1){

                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from aluno order by IdAluno");
                    con_cliente.resultset.first();
                    preencherTabela();
                    posicionarRegistro();

                }

                else{

                    JOptionPane.showMessageDialog(null, "Operação cancela pelo usuário!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }

        catch(SQLException excecao){

            JOptionPane.showMessageDialog(null, "Erro na exclusão: "  + excecao, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);

        }

    }                                       

    private void save_btnMouseClicked(java.awt.event.MouseEvent evt) {                                      

        //Criando strings para armazenar os dados digitados nos campos de texto
        String codigo = txtCod.getText();
        String nome = txtNome.getText();
        String datanasc = txtDataNasc.getText();
        String genero = txtGen.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTel.getText();
        String matricula = txtDataMat.getText();

        //
        try{

            String insert_sql = "insert into aluno (IdAluno, NomeAluno, DataNasc, Genero, Endereco, Telefone, DataMatricula) values ('" + codigo +"','"+ nome + "', "
            + "'" + datanasc + "', '" + genero + "', '" + endereco + "', '" + telefone + "', '" + matricula + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            con_cliente.executaSQL("select * from aluno order by IdAluno");
            con_cliente.resultset.first();
            preencherTabela();
            mostrar_Dados();

        }

        catch(SQLException errosql){

            JOptionPane.showMessageDialog(null, "Erro de gravação :\n " + errosql, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }                                     

    private void editar_btnMouseClicked(java.awt.event.MouseEvent evt) {                                        

        //Criando strings para armazenar os dados digitados nos campos de texto
        String nome = txtNome.getText();
        String datanasc = txtDataNasc.getText();
        String genero = txtGen.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTel.getText();
        String matricula = txtDataMat.getText();

        //
        String sql = "";

        //
        String msg = "";

        try{

            if(txtCod.getText().equals("")){

                sql = "insert into aluno (NomeAluno, DataNasc, Genero, Endereco, Telefone, DataMatricula) values (" + nome + "', '" + datanasc + "', '" + genero + "', '" +
                endereco + "', '" +  telefone + "', '" + matricula + "' where IdAluno = " + txtCod.getText();
                msg = "Gravação de um novo registro";

            }

            else{

                sql = "update aluno set NomeAluno = '" + nome + "', DataNasc = '" + datanasc + "', Genero = '" + genero + "', Endereco = '" + endereco + "', Telefone = '" +
                telefone + "', DataMatricula = '" + matricula + "' where IdAluno = " + txtCod.getText();
                msg = "Alteração de registro ";

            }

            con_cliente.statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, msg + "realizada com sucesso!", "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from aluno order by IdAluno");
            con_cliente.resultset.first();
            preencherTabela();
            mostrar_Dados();
        }

        catch(SQLException errosql){

            JOptionPane.showMessageDialog(null, "Erro de gravação :\n " + errosql, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }

        private void saveActionPerformed(java.awt.event.ActionEvent evt) {

            //Criando strings para armazenar os dados digitados nos campos de texto
            String codigo = txtCod.getText();
            String nome = txtNome.getText();
            String datanasc = txtDataNasc.getText();
            String genero = txtGen.getText();
            String endereco = txtEndereco.getText();
            String telefone = txtTel.getText();
            String matricula = txtDataMat.getText();

            //
            try{

                // Removendo IdAluno, '" + codigo + "',
                String insert_sql = "insert into aluno (IdAluno, NomeAluno, DataNasc, Genero, Endereco, Telefone, DataMatricula) values ('"+ codigo 
                        +"','" + nome + "', '" +datanasc + "', '" + genero + "', '" + endereco + "', '" + telefone + "', '" + matricula + "')";
                con_cliente.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                con_cliente.executaSQL("select * from aluno order by IdAluno");
                con_cliente.resultset.first();
                preencherTabela();
                mostrar_Dados();

            }

            catch(SQLException errosql){

                JOptionPane.showMessageDialog(null, "Erro de gravação :\n " + errosql, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
            }

    }                                       

    private void create_btnMouseClicked(java.awt.event.MouseEvent evt) {                                        

        //Limpa as caixas de texto
        txtCod.setText("");
        txtNome.setText("");
        txtDataNasc.setText("");
        txtGen.setText("");
        txtEndereco.setText("");
        txtTel.setText("");
        txtDataMat.setText("");

    }                                       

    private void UltimoRegistroMouseClicked(java.awt.event.MouseEvent evt) {                                            

        try{
            con_cliente.resultset.last();
            mostrar_Dados();
        }

        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o último registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }                                           

    private void ProximoRegistroMouseClicked(java.awt.event.MouseEvent evt) {                                             

        try{
            con_cliente.resultset.next();
            mostrar_Dados();
        }

        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }                                            

    private void VoltarUmRegistroMouseClicked(java.awt.event.MouseEvent evt) {                                              

        try{
            con_cliente.resultset.previous();
            mostrar_Dados();
        }

        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }                                             

    private void PrimeiroRegistroMouseClicked(java.awt.event.MouseEvent evt) {                                              

        try{
            con_cliente.resultset.first();
            mostrar_Dados();
        }

        catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro: " + erro, "Mensagem do programa ", JOptionPane.INFORMATION_MESSAGE);
        }

    }                                             

    private void backbtnMouseClicked(java.awt.event.MouseEvent evt) {                                     

        //Abrir a tela do curso e fechar a tela de menu.
        Menu menu = new Menu();
        menu.setVisible(true);
        dispose();

    }                                    

    private void alunoKeyPressed(java.awt.event.KeyEvent evt) {                                 

        //Evento que sincroniza a grid com as setas do teclado:
        int linha_selecionada = aluno.getSelectedRow();
        txtCod.setText(aluno.getValueAt(linha_selecionada, 0).toString());
        txtNome.setText(aluno.getValueAt(linha_selecionada, 1).toString());
        txtDataNasc.setText(aluno.getValueAt(linha_selecionada, 2).toString());
        txtGen.setText(aluno.getValueAt(linha_selecionada, 3).toString());
        txtEndereco.setText(aluno.getValueAt(linha_selecionada, 4).toString());
        txtTel.setText(aluno.getValueAt(linha_selecionada, 5).toString());
        txtDataMat.setText(aluno.getValueAt(linha_selecionada, 6).toString());
    }                                

    private void alunoMouseClicked(java.awt.event.MouseEvent evt) {                                   

        //Evento para o clique do mouse sobre o registro da tabela:
        int linha_selecionada = aluno.getSelectedRow();
        txtCod.setText(aluno.getValueAt(linha_selecionada, 0).toString());
        txtNome.setText(aluno.getValueAt(linha_selecionada, 1).toString());
        txtDataNasc.setText(aluno.getValueAt(linha_selecionada, 2).toString());
        txtGen.setText(aluno.getValueAt(linha_selecionada, 3).toString());
        txtEndereco.setText(aluno.getValueAt(linha_selecionada, 4).toString());
        txtTel.setText(aluno.getValueAt(linha_selecionada, 5).toString());
        txtDataMat.setText(aluno.getValueAt(linha_selecionada, 6).toString());

    }                                  

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel PrimeiroRegistro;
    private javax.swing.JLabel ProximoRegistro;
    private javax.swing.JLabel UltimoRegistro;
    private javax.swing.JLabel VoltarUmRegistro;
    private javax.swing.JTable aluno;
    private javax.swing.JLabel alunoimg_lbl;
    private javax.swing.JLabel backbtn;
    private javax.swing.JLabel cod_lbl;
    private javax.swing.JLabel create_btn;
    private javax.swing.JLabel delete_btn;
    private javax.swing.JLabel dtmat_lbl;
    private javax.swing.JLabel editar_btn;
    private javax.swing.JLabel gen_lbl;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nome_lbl;
    private javax.swing.JLabel save_btn;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDataMat;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtGen;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtTel;
    // End of variables declaration                   

}


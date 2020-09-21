package Midi;

import javax.sound.midi.*;
import java.awt.event.*;

public class Midiplayer extends javax.swing.JFrame {
    /*Initialize global variables*/
    Synthesizer midiSynth;
    Instrument[] instr;
    MidiChannel[] mChannels;
    Sequencer sequencer=null;
    Sequence mySeq=null;
    int currentInstrument=0;
    int note=60;
    int volume=100;

    public Midiplayer() {
        initComponents();
        initSynth();    //Function to load synth and first instrument
        updateInstrumentName();   //Function to update instrument name
        PlaySoundPanel.requestFocus();  //Sets the focus on the PlaySoundPanel 
    }
    
    public void initSynth() {
        try{
            midiSynth = MidiSystem.getSynthesizer(); 
            midiSynth.open();

            //get and load default instrument and channel lists
            instr = midiSynth.getDefaultSoundbank().getInstruments();
            mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[currentInstrument]);//load an instrument;
        } catch (MidiUnavailableException e) {}
    }
    
    //This Function is used to play sound
    public void playSound() {
            mChannels[0].noteOn(note, volume);//On channel 0, play note with the set volume.
            PlaySoundPanel.requestFocus();  //Sets the focus on the PlaySoundPanel
    }
    
    //This function is used to update instrument name
    public void updateInstrumentName() {
        String name=instr[currentInstrument].getName();
        txt_currentInstrument.setText(name);
    }
    
    //Function to go to next instrument
    public void nextInstrument() {
        int l = instr.length;
        
        if((currentInstrument+1) == l) {    //If last instrument then move to first
            currentInstrument=0;
        } else {
            currentInstrument++;
        }
        
        int bank = instr[currentInstrument].getPatch().getBank();
        int program = instr[currentInstrument].getPatch().getProgram();
        
        //Change the instrument using programChange(bank, preset)
        mChannels[0].programChange(bank, program);
        updateInstrumentName();
        PlaySoundPanel.requestFocus();  
    }
    
    //Function to go to previous instrument
    public void previousInstrument() {
        int firstInstrument=0;
        int l = instr.length;
        
        if(currentInstrument == firstInstrument) {  //If first instrument then move to last
            currentInstrument=l-1;
        } else {
            currentInstrument--;
        }
        
        int bank = instr[currentInstrument].getPatch().getBank();
        int program = instr[currentInstrument].getPatch().getProgram();
        
        //Change the instrument using programChange(bank, preset)
        mChannels[0].programChange(bank, program);
        updateInstrumentName();
        PlaySoundPanel.requestFocus();  
    }
    

    @SuppressWarnings("unchecked")
    private void initComponents() {

        PlaySoundPanel = new javax.swing.JPanel();
        btn_c = new javax.swing.JButton();
        btn_nextInstrument = new javax.swing.JButton();
        lbl_currentInstrument = new javax.swing.JLabel();
        txt_currentInstrument = new javax.swing.JLabel();
        btn_C = new javax.swing.JButton();
        btn_d = new javax.swing.JButton();
        btn_D = new javax.swing.JButton();
        btn_e = new javax.swing.JButton();
        btn_f = new javax.swing.JButton();
        btn_F = new javax.swing.JButton();
        btn_g = new javax.swing.JButton();
        btn_G = new javax.swing.JButton();
        btn_a = new javax.swing.JButton();
        btn_A = new javax.swing.JButton();
        btn_b = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_previousInstrument = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbl_playback = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Midi player");

        PlaySoundPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PlaySoundPanelKeyPressed(evt);
            }
        });
        
        // These functions adds the lables on the buttons.
        btn_c.setText("C");
        btn_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cActionPerformed(evt);
            }
        });

        btn_nextInstrument.setText("Next instrument (O)");
        btn_nextInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextInstrumentActionPerformed(evt);
            }
        });

        lbl_currentInstrument.setText("Current instrument :");

        txt_currentInstrument.setText("Not-Started");

        btn_C.setText("C#");
        btn_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CActionPerformed(evt);
            }
        });

        btn_d.setText("D");
        btn_d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dActionPerformed(evt);
            }
        });

        btn_D.setText("D#");
        btn_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DActionPerformed(evt);
            }
        });

        btn_e.setText("E");
        btn_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eActionPerformed(evt);
            }
        });

        btn_f.setText("F");
        btn_f.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_fActionPerformed(evt);
            }
        });

        btn_F.setText("F#");
        btn_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FActionPerformed(evt);
            }
        });

        btn_g.setText("G");
        btn_g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gActionPerformed(evt);
            }
        });

        btn_G.setText("G#");
        btn_G.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GActionPerformed(evt);
            }
        });

        btn_a.setText("A");
        btn_a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aActionPerformed(evt);
            }
        });

        btn_A.setText("A#");
        btn_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AActionPerformed(evt);
            }
        });

        btn_b.setText("B");
        btn_b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bActionPerformed(evt);
            }
        });

        // Adds the labels for the keyboard shortcuts.
        jLabel1.setText("1");

        jLabel2.setText("2");

        jLabel3.setText("3");

        jLabel4.setText("4");

        jLabel5.setText("5");

        jLabel6.setText("6");

        jLabel7.setText("7");

        jLabel8.setText("8");

        jLabel9.setText("9");

        jLabel10.setText("0");

        jLabel11.setText("-");

        jLabel12.setText("=");

        btn_previousInstrument.setText("Previous instrument (I)");
        btn_previousInstrument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousInstrumentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlaySoundPanelLayout = new javax.swing.GroupLayout(PlaySoundPanel);
        PlaySoundPanel.setLayout(PlaySoundPanelLayout);
        PlaySoundPanelLayout.setHorizontalGroup(
            PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_c)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(195, 195, 195)
                        .addComponent(jLabel7))
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addComponent(lbl_currentInstrument, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(17, 17, 17))
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(btn_C)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_d))
                                    .addComponent(btn_previousInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addComponent(btn_D)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_e)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_f)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_F)
                                .addGap(18, 18, 18)
                                .addComponent(btn_g))
                            .addComponent(txt_currentInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(49, 49, 49)
                                .addComponent(jLabel5)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(23, 23, 23))))
                    .addComponent(btn_nextInstrument, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_playback, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel9)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel10))
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addComponent(btn_G)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_a)))
                        .addGap(17, 17, 17)
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addComponent(btn_A)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_b))
                            .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel11)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel12))))
        )));
        PlaySoundPanelLayout.setVerticalGroup(
            PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlaySoundPanelLayout.createSequentialGroup()
                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_currentInstrument)
                            .addComponent(txt_currentInstrument))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_previousInstrument)
                        .addGap(9, 9, 9)
                        .addComponent(btn_nextInstrument))
                    .addGroup(PlaySoundPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(lbl_playback))
                        .addGap(18, 18, 18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlaySoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_c)
                    .addComponent(btn_C)
                    .addComponent(btn_d)
                    .addComponent(btn_D)
                    .addComponent(btn_e)
                    .addComponent(btn_f)
                    .addComponent(btn_F)
                    .addComponent(btn_g)
                    .addComponent(btn_G)
                    .addComponent(btn_a)
                    .addComponent(btn_A)
                    .addComponent(btn_b))
        ))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PlaySoundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PlaySoundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    //Events for button click
    private void btn_cActionPerformed(java.awt.event.ActionEvent evt) {
        note=60;
        playSound();
    }

    private void btn_nextInstrumentActionPerformed(java.awt.event.ActionEvent evt) {
        nextInstrument();
    }

    private void btn_CActionPerformed(java.awt.event.ActionEvent evt) {
        note=61;
        playSound();
    }

    private void btn_dActionPerformed(java.awt.event.ActionEvent evt) {
        note=62;
        playSound();
    }

    private void btn_DActionPerformed(java.awt.event.ActionEvent evt) {
        note=63;
        playSound();
    }

    private void btn_eActionPerformed(java.awt.event.ActionEvent evt) {
        note=64;
        playSound();
    }

    private void btn_fActionPerformed(java.awt.event.ActionEvent evt) {
        note=65;
        playSound();
    }

    private void btn_FActionPerformed(java.awt.event.ActionEvent evt) {
        note=66;
        playSound();
    }

    private void btn_gActionPerformed(java.awt.event.ActionEvent evt) {
        note=67;
        playSound();
    }

    private void btn_GActionPerformed(java.awt.event.ActionEvent evt) {
        note=68;
        playSound();
    }

    private void btn_aActionPerformed(java.awt.event.ActionEvent evt) {
        note=69;
        playSound();
    }

    private void btn_AActionPerformed(java.awt.event.ActionEvent evt) {
        note=70;
        playSound();
    }

    private void btn_bActionPerformed(java.awt.event.ActionEvent evt) {
        note=71;
        playSound();
    }

    private void btn_previousInstrumentActionPerformed(java.awt.event.ActionEvent evt) {
        previousInstrument();
    }

    //Events for keyboard key press
    private void PlaySoundPanelKeyPressed(java.awt.event.KeyEvent evt) {
        int keyCode = evt.getKeyCode();
        switch( keyCode ) { 
        case KeyEvent.VK_1: 
            //Similar code for button click event
            note=60;
            playSound();
            break;
        case KeyEvent.VK_2: 
            note=61;
            playSound();
            break;
        case KeyEvent.VK_3:
            note=62;
            playSound();
            break;
        case KeyEvent.VK_4 :
            note=63;
            playSound();
            break;
        case KeyEvent.VK_5 :
            note=64;
            playSound();
            break;
        case KeyEvent.VK_6 :
            note=65;
            playSound();
            break;
        case KeyEvent.VK_7 :
            note=66;
            playSound();
            break;
        case KeyEvent.VK_8 :
            note=67;
            playSound();
            break;
        case KeyEvent.VK_9 :
            note=68;
            playSound();
            break;
        case KeyEvent.VK_0 :
            note=69;
            playSound();
            break;
        case KeyEvent.VK_MINUS :
            note=70;
            playSound();
            break;
        case KeyEvent.VK_EQUALS :
            note=71;
            playSound();
            break;
        case KeyEvent.VK_I :
            previousInstrument();
            break;
        case KeyEvent.VK_O :
            nextInstrument();
            break;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Midiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Midiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Midiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Midiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Midiplayer().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JPanel PlaySoundPanel;
    private javax.swing.JButton btn_A;
    private javax.swing.JButton btn_C;
    private javax.swing.JButton btn_D;
    private javax.swing.JButton btn_F;
    private javax.swing.JButton btn_G;
    private javax.swing.JButton btn_a;
    private javax.swing.JButton btn_b;
    private javax.swing.JButton btn_c;
    private javax.swing.JButton btn_d;
    private javax.swing.JButton btn_e;
    private javax.swing.JButton btn_f;
    private javax.swing.JButton btn_g;
    private javax.swing.JButton btn_nextInstrument;
    private javax.swing.JButton btn_previousInstrument;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_currentInstrument;
    private javax.swing.JLabel lbl_playback;
    private javax.swing.JLabel txt_currentInstrument;
    // End of variables declaration
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class MyNotepad extends JFrame implements ActionListener {
   JMenuBar mb;
   JMenu filemenu, editmenu, formatmenu, helpmenu;
   JMenuItem newitem, openitem, saveitem,
         printitem, exititem, undoitem, cutitem, copyitem, pasteitem,
         deleteitem, finditem, findnextitem, replaceitem, gotoitem,
         selectallitem, timedateitem, wordwrapitem, fontitem,
         aboutnotepaditem;
   JTextArea ta;
   JScrollPane jsp;
   JFileChooser jfc;
   JColorChooser jc;
   Font f = new Font("Arial", 3, 20);
   public MyNotepad() {
      jfc = new JFileChooser();
      jc = new JColorChooser();
      ta = new JTextArea();
      ta.setFont(f);
      int vsp = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
      int hsp = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
      jsp = new JScrollPane(ta, vsp, hsp);
      add(jsp);
      mb = new JMenuBar();
      setJMenuBar(mb);
      filemenu = new JMenu("File");
      editmenu = new JMenu("Edit");
      formatmenu = new JMenu("Format");
      helpmenu = new JMenu("Help");
      mb.add(filemenu);
      mb.add(editmenu);
      mb.add(formatmenu);
      mb.add(helpmenu);
      newitem = new JMenuItem("New");
      newitem.setAccelerator(KeyStroke.getKeyStroke('N', 1));
      openitem = new JMenuItem("Open");
      saveitem = new JMenuItem("Save");
      exititem = new JMenuItem("Exit");
      exititem.setAccelerator(KeyStroke.getKeyStroke('X',
            InputEvent.ALT_DOWN_MASK));
      undoitem = new JMenuItem("Undo");
      cutitem = new JMenuItem("Cut");
      cutitem.setAccelerator(KeyStroke.getKeyStroke('X',
            InputEvent.CTRL_DOWN_MASK));
      copyitem = new JMenuItem("Copy");
	  copyitem.setAccelerator(KeyStroke.getKeyStroke('C',
            InputEvent.CTRL_DOWN_MASK));
      pasteitem = new JMenuItem("Paste");
	  pasteitem.setAccelerator(KeyStroke.getKeyStroke('P',
            InputEvent.CTRL_DOWN_MASK));
      fontitem = new JMenuItem("Color  ");
      aboutnotepaditem = new JMenuItem("About Notepad");
      filemenu.add(newitem);
      filemenu.add(openitem);
      filemenu.add(saveitem);
      filemenu.addSeparator();
      filemenu.add(exititem);
      editmenu.add(undoitem);
      editmenu.addSeparator();
      editmenu.add(cutitem);
      editmenu.add(copyitem);
      editmenu.add(pasteitem);
      formatmenu.add(fontitem);
      helpmenu.add(aboutnotepaditem);
      setTitle("Untitled - MYNotepad");
      setVisible(true);
      setExtendedState(MAXIMIZED_BOTH);
      newitem.addActionListener(this);
      openitem.addActionListener(this);
      saveitem.addActionListener(this);
	  undoitem.addActionListener(this);
      exititem.addActionListener(this);
      copyitem.addActionListener(this);
      cutitem.addActionListener(this);
      pasteitem.addActionListener(this);
      fontitem.addActionListener(this);
	  aboutnotepaditem.addActionListener(this);
   }
   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == exititem) {
		 String s = ta.getText();
         if (!(s.equalsIgnoreCase(""))) {
            int opt = JOptionPane.showConfirmDialog(this,
                  "Do you want to save the previous data?");
            if (opt == JOptionPane.YES_OPTION) {
               jfc.showSaveDialog(this);
               try {
                  FileWriter fw = new FileWriter(jfc.getSelectedFile());
                  String data = ta.getText();
                  fw.write(data + "\n");
                  fw.close();
               } catch (Exception e) {
                  JOptionPane.showMessageDialog(this, "Error in write",
                        "Error", JOptionPane.ERROR_MESSAGE);
               }
					
            }
			else if(opt == JOptionPane.NO_OPTION) {
				System.exit(0);
				}
			else{	
			}
         } else {
            System.exit(0);
            } 
         } 
         
      if (ae.getSource() == newitem) {
         ta.setText("");
      }
	   if (ae.getSource() == undoitem) {
      }
      if (ae.getSource() == copyitem) {
         ta.copy();
      }
      if (ae.getSource() == pasteitem) {
         ta.paste();
      }
      if (ae.getSource() == cutitem) {
         ta.cut();
      }
      if (ae.getSource() == openitem) {
         String s = ta.getText();
         if (!(s.equalsIgnoreCase(""))) {
            int opt = JOptionPane.showConfirmDialog(this,
                  "Do u want to save the previous data?y/n");
            if (opt == JOptionPane.YES_OPTION) {
               jfc.showSaveDialog(this);
               try {
                  FileWriter fw = new FileWriter(jfc.getSelectedFile());
                  String data = ta.getText();
                  fw.write(data + "\n");
                  fw.close();
               } catch (Exception e) {
                  JOptionPane.showMessageDialog(this, "Error in write",
                        "Error", JOptionPane.ERROR_MESSAGE);
               }
			   
            }
         } else {
            jfc.showOpenDialog(this);
            try {
               FileReader fr = new FileReader(jfc.getSelectedFile());
               BufferedReader br = new BufferedReader(fr);
               String data = "";
               ta.setText("");
               while ((data = br.readLine()) != null) {
                  ta.append(data + "\n");
               }
               fr.close();
            } catch (Exception e) {
               JOptionPane.showMessageDialog(this, "Error in open",
                     "Error", JOptionPane.ERROR_MESSAGE);
            }
         }
      }
      if (ae.getSource() == saveitem) {
         jfc.showSaveDialog(this);
         try {
            FileWriter fw = new FileWriter(jfc.getSelectedFile());
            String data = ta.getText();
            fw.write(data + "\n");
            fw.close();
         } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error in write", "Error",
                  JOptionPane.ERROR_MESSAGE);
         }
      }
      if (ae.getSource() == fontitem) {
         ta.setForeground(jc.showDialog(this, "Color", Color.yellow));
      }
	   if (ae.getSource() == aboutnotepaditem) {
            JOptionPane.showMessageDialog(this, "My Notepad Version 0.1 Created by: Arvind Iyer	");
      }
   }
   public static void main(String args[]) {
      new MyNotepad();
   }
}
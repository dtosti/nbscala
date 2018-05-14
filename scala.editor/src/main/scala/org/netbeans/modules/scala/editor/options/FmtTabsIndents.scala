/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2006 Sun
 * Microsystems, Inc. All Rights Reserved.
 */

package org.netbeans.modules.scala.editor.options

import org.netbeans.api.editor.settings.SimpleValueNames
import org.netbeans.modules.options.editor.spi.PreferencesCustomizer
import org.openide.util.NbBundle

import javax.swing.GroupLayout
import javax.swing.LayoutStyle

import org.netbeans.modules.scala.editor.options.FmtOptions._

/**
 *
 * @author  phrebejk
 */
object FmtTabsIndents {
  def getController: PreferencesCustomizer.Factory = {
    new FmtOptions.Factory(PreferencesCustomizer.TABS_AND_INDENTS_ID,
      classOf[FmtTabsIndents],
      NbBundle.getMessage(classOf[FmtTabsIndents], "SAMPLE_Indents"), // NOI18N
      Array(SimpleValueNames.TEXT_LIMIT_WIDTH, "30"))
  }
}

class FmtTabsIndents extends javax.swing.JPanel {

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private var continuationIndentSizeField: javax.swing.JTextField = _
  private var continuationIndentSizeLabel: javax.swing.JLabel = _
  private var indentHtmlCheckBox: javax.swing.JCheckBox = _
  private var indentSizeField: javax.swing.JTextField = _
  private var indentSizeLabel: javax.swing.JLabel = _
  private var jCheckBox3: javax.swing.JCheckBox = _
  private var jTextField3: javax.swing.JTextField = _
  private var reformatCommentsCheckBox: javax.swing.JCheckBox = _
  // End of variables declaration//GEN-END:variables

  initComponents
  // Not yet implemented
  //indentCasesFromSwitchCheckBox.setVisible(false);

  indentSizeField.putClientProperty(Customizer.OPTION_ID, SimpleValueNames.INDENT_SHIFT_WIDTH)
  continuationIndentSizeField.putClientProperty(Customizer.OPTION_ID, continuationIndentSize)
  reformatCommentsCheckBox.putClientProperty(Customizer.OPTION_ID, reformatComments)
  indentHtmlCheckBox.putClientProperty(Customizer.OPTION_ID, indentXml)

  /**
   * This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
  private def initComponents {

    jTextField3 = new javax.swing.JTextField()
    jCheckBox3 = new javax.swing.JCheckBox()
    indentSizeLabel = new javax.swing.JLabel()
    indentSizeField = new javax.swing.JTextField()
    continuationIndentSizeLabel = new javax.swing.JLabel()
    continuationIndentSizeField = new javax.swing.JTextField()
    reformatCommentsCheckBox = new javax.swing.JCheckBox()
    indentHtmlCheckBox = new javax.swing.JCheckBox()

    jTextField3.setText("jTextField3");

    org.openide.awt.Mnemonics.setLocalizedText(jCheckBox3, "jCheckBox3");
    jCheckBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    jCheckBox3.setMargin(new java.awt.Insets(0, 0, 0, 0));

    setOpaque(false);

    org.openide.awt.Mnemonics.setLocalizedText(indentSizeLabel, org.openide.util.NbBundle.getMessage(classOf[FmtTabsIndents], "LBL_IndentSize")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(continuationIndentSizeLabel, org.openide.util.NbBundle.getMessage(classOf[FmtTabsIndents], "LBL_ContinuationIndentSize")); // NOI18N

    org.openide.awt.Mnemonics.setLocalizedText(reformatCommentsCheckBox, org.openide.util.NbBundle.getMessage(classOf[FmtTabsIndents], "LBL_ReformatComments")); // NOI18N
    reformatCommentsCheckBox.setMargin(new java.awt.Insets(0, 0, 0, 0));

    org.openide.awt.Mnemonics.setLocalizedText(indentHtmlCheckBox, org.openide.util.NbBundle.getMessage(classOf[FmtTabsIndents], "LBL_IndentHTML")); // NOI18N

    val layout = new GroupLayout(this)
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(indentSizeLabel)
            .addComponent(continuationIndentSizeLabel))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
              .addComponent(indentSizeLabel)
              .addComponent(continuationIndentSizeLabel, GroupLayout.DEFAULT_SIZE, 75, Short.MaxValue)))
          .addComponent(reformatCommentsCheckBox)
          .addComponent(indentHtmlCheckBox))
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MaxValue)))

    layout.setVerticalGroup(
      layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
          .addComponent(indentSizeLabel)
          .addComponent(indentSizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(14, 14, 14)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(continuationIndentSizeLabel)
            .addComponent(continuationIndentSizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18, 18, 18)
          .addComponent(reformatCommentsCheckBox)
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addComponent(indentHtmlCheckBox)
          .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MaxValue)))
  } // </editor-fold>//GEN-END:initComponents

}

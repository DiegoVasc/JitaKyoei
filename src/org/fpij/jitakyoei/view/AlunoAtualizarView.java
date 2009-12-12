package org.fpij.jitakyoei.view;

import java.util.List;

import javax.swing.JPanel;

import net.java.dev.genesis.annotation.Action;
import net.java.dev.genesis.annotation.Form;
import net.java.dev.genesis.ui.swing.SwingBinder;

import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.view.forms.AlunoForm;
import org.fpij.jitakyoei.view.gui.AlunoAtualizarPanel;
@Form
public class AlunoAtualizarView implements AlunoView, ViewComponent{
	AlunoAtualizarPanel gui;
	private AlunoForm alunoForm;
	
	public AlunoAtualizarView(){
		gui = new AlunoAtualizarPanel();
		new SwingBinder(gui , this).bind();		
		alunoForm = new AlunoForm(gui.getAlunoPanel());
		gui.setVisible(true);
	}
	
	@Action
	public void atualizar(){
		Aluno aluno = alunoForm.pegarBean();
		System.out.println(aluno.toString());		
	}
	
	@Override
	public JPanel getGui(){
		return gui;
	}

	@Override
	public void displayResult(Aluno aluno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayResult(List<Aluno> searchResult) {
		// TODO Auto-generated method stub

	}

}
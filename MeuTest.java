package org.fpij.jitakyoei.pdsi2;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.fpij.jitakyoei.facade.AppFacade;
import org.fpij.jitakyoei.facade.AppFacadeImpl;
import org.fpij.jitakyoei.model.beans.Aluno;
import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.model.beans.ProfessorEntidade;
import org.fpij.jitakyoei.model.beans.Rg;
import org.fpij.jitakyoei.view.AppView;
import org.fpij.jitakyoei.view.MainAppView;
import org.junit.Test;

public class MeuTest {
	
	AppView view = new MainAppView();
	AppFacade facade = new AppFacadeImpl(view);
		
	@Test(expected=Exception.class)
	public void testCPFTem11DigitosInvalido() throws Exception{
		//Dado que eu tenho...
		Filiado filiado = new Filiado();
		filiado.setCpf("12345678910");
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		//Quando tentar criar cadastrar o aluno...
		facade.createAluno(aluno);
		//Então, espera que...
		
	}
	
	@Test(expected=Exception.class)
	public void testCPFNullInvalido() throws Exception{
		
		String cpf = null;
		
		Filiado filiado = new Filiado();
		filiado.setCpf(cpf);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
	}
	
	@Test
	public void testCPFTem11DigitosValidos() throws Exception{
		//Dado que eu tenho...
		String cpf = "12345678910";
		Filiado filiado = new Filiado();
		filiado.setCpf(cpf);
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		//Quando tentar criar cadastrar o aluno...
		facade.createAluno(aluno);
		String cpfcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getCpf();
		//Então, espera que...
		assertEquals("Não são iguais", cpf, cpfcadastrado);
		
	}
	
	@Test(expected=Exception.class)
	public void testCEPTem8DigitosInvalido() throws Exception{
		//Dado que eu tenho...
		Endereco endereco = new Endereco();
		endereco.setCep("64500000");
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		//Quando tentar criar cadastrar o aluno...
		facade.createAluno(aluno);
		//Então, espera que...
		
	}
	
	@Test
	public void testCEPValido() {
		
		String cep = "64600000";
		
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		
		Filiado filiado = new Filiado();
		filiado.setEndereco(endereco);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
		
		String cepcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEndereco().getCep();
		//Então, espera que...
		assertEquals("Não são iguais", cep, cepcadastrado);

	}
	
	@Test(expected=Exception.class)
	public void testEmailInvalido() throws Exception{
		
		String email = "fabriciosousa16";
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	@Test(expected=Exception.class)
	public void testEmailNull() throws Exception{
		
		String email = null;
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);
	}
	
	
	@Test
	public void testEmailValido() throws Exception {
		
		String email = "marciosilvano139@gmail.com";
		
		Filiado filiado = new Filiado();
		filiado.setEmail(email);
		
		Aluno aluno = new Aluno();
		aluno.setFiliado(filiado);
		
		facade.createAluno(aluno);

		String emailcadastrado = facade.searchAluno(aluno).get(0).getFiliado().getEmail();
		
		assertEquals("Não são iguais", email, emailcadastrado);
		
	}

	@Test(expected=Exception.class)
	public void testNomeNumeroInvalido() throws Exception {
	
	String user_name = "1234567890";
		
	Filiado file = new Filiado();
	file.setNome(user_name);
	
	Aluno student = new Aluno();
	student.setFiliado(file);
	
	facade.createAluno(student);
	
	}
	
	@Test(expected=Exception.class)
	public void testNomeNull() throws Exception {
	
	String user_name = null;
		
	Filiado file = new Filiado();
	file.setNome(user_name);
	
	Aluno student = new Aluno();
	student.setFiliado(file);
	
	facade.createAluno(student);
	
	}

	@Test
	public void testNomeValido() {
	
	String user_name = "Fabricio Jose de Sousa";
	
	Filiado file = new Filiado();
	file.setNome(user_name);
	
	Aluno student = new Aluno();
	student.setFiliado(file);
	
	facade.createAluno(student);
	
	String data_name = facade.searchAluno(student).get(0).getFiliado().getNome();
	
	assertEquals("Não são iguais", user_name, data_name);
	
	}
	
	@Test(expected=Exception.class)
	public void testRuaNullInvalido() throws Exception{
		
		String street = null;
		
		Endereco street_address = new Endereco();
		street_address.setRua(street);
		
		Filiado file = new Filiado();
		file.setEndereco(street_address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test
	public void testRuaValido() {
		
		String street = "Pedro Claro";
		
		Endereco street_address = new Endereco();
		street_address.setRua(street);
		
		Filiado file = new Filiado();
		file.setEndereco(street_address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_street = facade.searchAluno(student).get(0).getFiliado().getEndereco().getRua();
		
		assertEquals("Não são iguais", street, data_street);

	}
	
	@Test(expected=Exception.class)
	public void testBairroNullInvalido() throws Exception{
		
		String district = null;
		
		Endereco address = new Endereco();
		address.setBairro(district);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test
	public void testBairroValido() {
		
		String district = "Centro";
		
		Endereco address = new Endereco();
		address.setBairro(district);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_district = facade.searchAluno(student).get(0).getFiliado().getEndereco().getBairro();
		
		assertEquals("Não são iguais", district, data_district);

	}
	
	@Test(expected=Exception.class)
	public void testCidadeNullInvalido() throws Exception{
		
		String city= null;
		
		Endereco address = new Endereco();
		address.setCidade(city);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test
	public void testCidadeValido() {
		
		String city = "Picos";
		
		Endereco address = new Endereco();
		address.setCidade(city);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_city = facade.searchAluno(student).get(0).getFiliado().getEndereco().getCidade();
		
		assertEquals("Não são iguais", city, data_city);
	}
	
	@Test(expected=Exception.class)
	public void testEstadoNullInvalido() throws Exception{
		
		String state= null;
		
		Endereco address = new Endereco();
		address.setEstado(state);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test
	public void testEstadoValido() {
		
		String state = "Piaui";
		
		Endereco address = new Endereco();
		address.setEstado(state);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_state = facade.searchAluno(student).get(0).getFiliado().getEndereco().getEstado();
		
		assertEquals("Não são iguais", state, data_state);
	}
	
	@Test(expected=Exception.class)
	public void testNumeroNullInvalido() throws Exception{
		
		String number= null;
		
		Endereco address = new Endereco();
		address.setNumero(number);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test(expected=Exception.class)
	public void testNumeroInvalido() throws Exception{
		
		String number= "abcdefghijklmnopqrstuvwxyz";
		
		Endereco address = new Endereco();
		address.setNumero(number);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);	
	}
	
	@Test
	public void testNumeroValido() {
		
		String number = "8555";
		
		Endereco address = new Endereco();
		address.setNumero(number);
		
		Filiado file = new Filiado();
		file.setEndereco(address);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_number = facade.searchAluno(student).get(0).getFiliado().getEndereco().getNumero();
		
		assertEquals("Não são iguais", number, data_number);
	}
	
	@Test(expected=Exception.class)
	public void testFone1Invalido() throws Exception{
		
		String phone = "abcdefghijklmnopqrstuvwxyz";
		
		Filiado file = new Filiado();
		file.setTelefone1(phone);
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
			
	}
	
	@Test
	public void testFone1Valido() throws Exception{
			
			String phone = "89994123086";
			
			Filiado file = new Filiado();
			file.setTelefone1(phone);
			
			Aluno student = new Aluno();
			student.setFiliado(file);
			
			facade.createAluno(student);
			
			String data_phone = facade.searchAluno(student).get(0).getFiliado().getTelefone1();
			
			assertEquals("Não são iguais", phone, data_phone);
		}
	
	@Test(expected=Exception.class)
	public void testFone2Invalido() throws Exception{
		
		String phone = "abcdefghijklmnopqrstuvwxyz";
		
		Filiado file = new Filiado();
		file.setTelefone2(phone);
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
			
	}
	
	@Test
	public void testFone2Valido() throws Exception{
			
			String phone = "89994123086";
			
			Filiado file = new Filiado();
			file.setTelefone2(phone);
			
			Aluno student = new Aluno();
			student.setFiliado(file);
			
			facade.createAluno(student);
			
			String data_phone = facade.searchAluno(student).get(0).getFiliado().getTelefone2();
			
			assertEquals("Não são iguais", phone, data_phone);
		}
	
	@Test(expected=Exception.class)
	public void testDataNascimentoInvalida(){
		
		@SuppressWarnings("deprecation")
		java.util.Date date = new java.util.Date("23/10/2018") ;
		
		Filiado file = new Filiado();
		file.setDataNascimento(date);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
	}
	
	@Test
	public void testDataNascimentoValida(){
		
		@SuppressWarnings("deprecation")
		java.util.Date date = new java.util.Date("23/10/2017") ;
		
		Filiado file = new Filiado();
		file.setDataNascimento(date);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		java.util.Date data_date = facade.searchAluno(student).get(0).getFiliado().getDataNascimento();
		assertEquals("Data de nascimento válida!", date, data_date);
		
	}
	
	@Test(expected=Exception.class)
	public void testRGInvalido(){
		
		String number_rg = "abcd";
		
		Rg rg = new Rg();
		rg.setNumero(number_rg);
		
		Filiado file = new Filiado();
		file.setRg(rg);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
	}
	
	@Test
	public void testRGValido(){
		
		String number_rg = "1234";
		//Rg rgcadastrado = new Rg();		
		
		Rg rg = new Rg();
		rg.setNumero(number_rg);
		
		Filiado file = new Filiado();
		file.setRg(rg);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_rg = facade.searchAluno(student).get(0).getFiliado().getRg().getNumero();
		assertEquals("Rg válido!", number_rg, data_rg);
	}
	
	@Test(expected=Exception.class)
	public void testOrgaoExpedidorInvalido(){
		
		String org = "123";
		
		Rg rg = new Rg();
		rg.setOrgaoExpedidor(org);
		
		Filiado file = new Filiado();
		file.setRg(rg);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
	}
	
	@Test
	public void testOrgaoExpedidorValido(){
		
		String org = "SSP";		
		
		Rg rg = new Rg();
		rg.setOrgaoExpedidor(org);;
		
		Filiado file = new Filiado();
		file.setRg(rg);
		
		Aluno student = new Aluno();
		student.setFiliado(file);
		
		facade.createAluno(student);
		
		String data_rg = facade.searchAluno(student).get(0).getFiliado().getRg().getOrgaoExpedidor();
		assertEquals("Rg válido!", org, data_rg);
	
	}
	
}
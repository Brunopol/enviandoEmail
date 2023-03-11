package enviandoEmail.enviandoEmail;


import enviandoEmail.enviandoEmail.classes.ObjetoEnviarEmailComAnexo;


public class App {
	public static void main(String[] args) {
		StringBuilder stringBuilderTextoEmail = new StringBuilder();

		stringBuilderTextoEmail.append("<button type=\"button\">Click Me!</button><br></br>");
		stringBuilderTextoEmail.append("this is a test<br></br>");
		stringBuilderTextoEmail.append("<b>this is a test</b>");

		ObjetoEnviarEmailComAnexo enviarEmail = new ObjetoEnviarEmailComAnexo("Testando", "bettiol.2023@gmail.com",
				"Este é o assunto", stringBuilderTextoEmail.toString(), "esteNomeParaAnexo",
				"/home/bruno/eclipse-workspace/enviandoEmail/src/main/java/enviandoEmail/enviandoEmail/anexos/Untitled 1","text/plain");

		enviarEmail.enviarEmail(true); // aqui pode ser false ou true, true para html, false para não html

	}
}

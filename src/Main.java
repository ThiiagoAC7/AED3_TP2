import java.io.IOException;
import java.util.Scanner;

/**
 * MAIN PROVISORIA
 * -ADAPTAR
 */
class Main {

	public static void main(String[] args) throws IOException{   
		CRUD<Paciente> crud;
		try {
      crud = new CRUD<>(Paciente.class.getConstructor());
      Scanner in = new Scanner(System.in);
      int menu;
      
      do{
        System.out.println("\n1- Inserir Paciente");
        System.out.println("2- Imprimir Paciente");
        System.out.println("3- Atualizar Paciente");
        System.out.println("4- Deletar Paciente");
        System.out.println("5- Imprimir Arquivos");
        System.out.println("0- Sair\n");
        System.out.println("Número do Menu: ");
      }

    }catch (Exception e) {
      e.printStackTrace();
    }
	}

}
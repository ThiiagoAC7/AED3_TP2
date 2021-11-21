import java.util.Scanner;
import java.util.Date;

public class Main{
    /**
     * Integrantes do Trabalho: Reynaldo Villar Garavini, Thiago Amado Costa
     */
    public static void main(String[] args) {

        CRUD<Paciente> crud;
        try {
            crud = new CRUD<>(Paciente.class.getConstructor());
            Scanner in = new Scanner(System.in);
            int menu;

            do{
                System.out.println("\n1- Inserir Cliente");
                System.out.println("2- Imprimir Cliente");
                System.out.println("3- Atualizar Cliente");
                System.out.println("4- Deletar Cliente");
                System.out.println("5- Imprimir Arquivos");
                System.out.println("0- Sair\n");
                System.out.print("Opção: ");
                menu = in.nextInt();
                //avança para proxima linha
                in.nextLine();
                System.out.print("\n");

                switch(menu) {
                    //Inserir
                    case 1: 
                        //ler nome
                        System.out.print("Nome............: ");
                        String nome1 = in.nextLine();
                        System.out.print("\n");
                        //ler data de nascimento
                        System.out.print("DataDeNascimento: ");
                        String strData1 = in.nextLine();
                        Date dataDeNascimento1 = dateUtil.stringToDate(strData1);
                        System.out.print("\n");
                        //ler sexo
                        System.out.print("Sexo(M/F).......: ");
                        char sexo1 = in.nextLine().charAt(0);
                        System.out.print("\n");
                        //ler anotações
                        System.out.print("Anotações.......:");
                        String anotacoes1 = in.nextLine();
                        System.out.println("\n");

                        //cria objeto paciente
                        Paciente p1 = new Paciente(-1, nome1, dataDeNascimento1, sexo1, anotacoes1);
                        
                        //função inserir do CRUD passando o novo cliente como parâmetro
                        crud.create(p1);

                        break;
                    //Imprimir
                    case 2:
                        //ler id
                        System.out.print("ID: ");
                        int id2 = in.nextInt();
                        System.out.print("\n");

                        //função imprimir do CRUD
                        Paciente p2 = crud.read(id2);

                        if(p2 != null) {
                            //imprime informações do paciente na tela
                            System.out.println(p2.toString());                            
                        } else {
                            //mensagem de erro
                            System.out.println("Paciente de ID " + id2 + " não existe");
                        }
                        break;
                    //Atualizar
                    case 3: 
                        //ler id
                        System.out.print("ID...: ");
                        int id3 = in.nextInt();
                        System.out.print("\n");
                        //avança para proxima linha
                        in.nextLine();
                        //ler nome
                        System.out.print("Nome............: ");
                        String nome3 = in.nextLine();
                        System.out.print("\n");
                        //ler data de nascimento
                        System.out.print("DataDeNascimento: ");
                        String strData3 = in.nextLine();
                        Date dataDeNascimento3 = dateUtil.stringToDate(strData3);
                        System.out.print("\n");
                        //ler sexo
                        System.out.print("Sexo(M/F).......: ");
                        char sexo3 = in.nextLine().charAt(0);
                        System.out.print("\n");
                        //ler anotações
                        System.out.print("Anotações.......:");
                        String anotacoes3 = in.nextLine();
                        System.out.println("\n");

                        //cria objeto paciente
                        Paciente p3 = new Paciente(id3, nome3, dataDeNascimento3, sexo3, anotacoes3);

                        //função atualizar CRUD passando o novo paciente como parâmetro
                        crud.update(p3);

                        break;
                    //Deletar
                    case 4:
                        //ler id
                        System.out.print("ID: ");
                        int id4 = in.nextInt();
                        System.out.print("\n");

                        //função delete CRUD
                        boolean deletado = crud.delete(id4);

                        if(deletado) {
                            System.out.println("Paciente deletado com sucesso!");
                        } else {
                            System.out.println("Erro ao deletar paciente!");
                        }

                        break;

                    case 5:
                        //função ler todos os paciente do CRUD
                        crud.readAll();
                        break;
                    //Sair
                    case 0: 
                        //mensagem de saída do programa
                        System.out.println("Programa Encerrado!");
                        break;
                    //Erro - Número Inválido
                    default:
                        System.out.println("Número Inválido!");
                        break;
                }

            } while(menu!=0);

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
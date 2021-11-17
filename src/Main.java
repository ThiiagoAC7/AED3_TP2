import java.io.IOException;

class Main {

	public static void main(String[] args) throws IOException{   
		CRUD<Paciente> crud;
		try {
      crud = new CRUD<>(Paciente.class.getConstructor());
      Paciente p = new Paciente(1,"Thiago Amado Costa",dateUtil.stringToDate("02/08/2000"),'M',"anotaçoes aksdjfskjdkfsajflçjaslkçfjsadkljfasklfjkadsjfkladsjfkladsjkfladsklfjadsklf");
      int id = crud.create(p);
      MyIO.println("Objeto Criadissimo : "+ id);
      MyIO.println("Objeto : ");
      System.out.println(crud.read(id).toString());
      Paciente pnovo = new Paciente(1,"Thiago Amado",dateUtil.stringToDate("02/08/2000"),'M',"anotaçoes asdasdasdad");

      if ( crud.update(pnovo) ) { 
        MyIO.println("Atualizado");
        System.out.println(crud.read(id).toString());	 
      }

      // if (crud.delete(id)) MyIO.println("Deletado");
    }catch (Exception e) {
      MyIO.println("ERRO:"+e.getMessage());
    }
	}

}
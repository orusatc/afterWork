package dataStorage;

public enum TestData {
    CONGRATULATION("Вітаємо,");

    private String data;

   TestData(String data){
       this.data = data;
   }

   public String getData(){
       return data;
   }
}

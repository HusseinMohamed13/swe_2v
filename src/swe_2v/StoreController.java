package swe_2v;

import java.io.IOException;

public class StoreController {
	private int size;
	 private Store ListOfStores[]= new Store[10];
    
    public StoreController() {
   	 size=0;
   	 for(int x=0;x<10;x++) {
   		 ListOfStores[x]=new Store();
   	 }
    }
    public void set() throws IOException {
    	LoadDB ld = new LoadDB();
   	    ListOfStores = ld.setStoreDB();
   	    size = ld.GetSize();  
    }
    public void AddStore(Store s) throws IOException  {
   	    LoadDB ld = new LoadDB();
   	    ListOfStores = ld.setStoreDB();
	    size = ld.GetSize();
   	    ld.AddToStoreDB(s);
   	    ListOfStores[size++]=s;
    }
    public void AddCollabortors(Collaborators c,String s) throws IOException  {
      	LoadDB ld = new LoadDB();
        ListOfStores = ld.setStoreDB();
 	    size = ld.GetSize();
      	ld.AddCollabortors(c, s);
    }
}

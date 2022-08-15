package Pi.Spring.response;

import Pi.Spring.Entity.Post;
import Pi.Spring.Entity.Type;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Com {
 private String com;

public String getCom() {
	return com;
}

public void setCom(String com) {
	this.com = com;
}

public Com(String com) {
	super();
	this.com = com;
}


 
}

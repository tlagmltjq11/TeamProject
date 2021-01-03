package Thread;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import DB.DB;


public class RankingThread extends Thread{

	private DB db;
	private DataOutputStream outputstream;
	private Socket s;

	
	public RankingThread(Socket s) {
		try {
			this.s = s;
			db = new DB();
			outputstream = new DataOutputStream(s.getOutputStream());  
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}



	public void run() {
		try {
			
			db.connect();
			while(outputstream != null) {
				
				int i = 1;
				int j=0;
				String num;
				db.read("select count(*) from account;");
				db.rs.next();
				num = db.rs.getString("count(*)");
				outputstream.writeUTF(num);
				// DBMS�� "account ���̺��� id, score�� ���� ���������� �����ض�"��� ��ɾ ������ �� ������� rs�� ����
				db.read("select id,score from account order by score desc;");
				// DB���� ������ id�� score�� ������� ����ǥ ���̺�(JTable)�� ����, ID, ���� ������ ����
				while(db.rs.next()) {
					String sqlRecipeProcess_id = db.rs.getString("id");
					String sqlRecipeProcess_score = db.rs.getString("score");
					outputstream.writeUTF(String.valueOf(i));
					outputstream.writeUTF(String.valueOf(j));
					outputstream.writeUTF(sqlRecipeProcess_id);
					outputstream.writeUTF(sqlRecipeProcess_score);
					i++;
					j++;
				}
				
			}
			db.rs.close();
			db.st.close();
			db.connection.close();
		} catch (SQLException se1) {
			se1.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (db.st != null)
					db.st.close();
			} catch (SQLException se2) {
			}
			try {
				if (db.connection != null)
					db.connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}    
	}


}

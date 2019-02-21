package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddminDelete{
	public static void main(String[] args){
		AddminDelete.DeleteResponseTable(1);
	}
	
	public static void DeleteTest(String sql){
		try{
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","tuser","pass");
			
			//自動コミットをOFFにする
			cn.setAutoCommit(false);
			
			System.out.println("接続完了");
			
			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			Statement st=cn.createStatement();
			
			//SQLを実行しトランザクションが開始される。
			st.executeUpdate(sql);
			
			//トランザクションをコミットする
			cn.commit();
			
			//ステートメントをクローズする
			st.close();
			
			//RDBMSから切断する
			cn.close();
			
			System.out.println("切断完了");
			System.out.println("デリート文だよ");
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void DeleteResponseTable(int resnum){
		String sql="delete from RESPONSE_TABLE where Response_No = "+resnum;
		
		DeleteTest(sql);
	}
	public static void DeleteThreadTable(int threadnum){
		String sql1="delete from RESPONSE_TABLE where Thread_No = "+ threadnum;
		String sql2="delete from THREAD_TABLE where Thread_No = "+threadnum;
		DeleteTest(sql1);
		DeleteTest(sql2);
	}
}


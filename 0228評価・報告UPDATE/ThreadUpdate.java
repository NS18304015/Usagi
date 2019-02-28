package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ThreadUpdate{
	public static void main(String[] args){
		ThreadUpdate.UpdateRating("1");
	}
	
	public static void Update(String sql){
		try{
			//Driverインターフェイスを実装するクラスをロードする
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Connectionインターフェイスを実装するクラスの
			//インスタンスを返す
			Connection cn=
				DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl","usagi","pass");
			
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
			//System.out.println(sql);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void UpdateRating(String rating){
		String sql="UPDATE RESPONSE_TABLE SET Response_Rating = (SELECT Response_Rating + 1 FROM RESPONSE_TABLE WHERE Response_No = "+ rating +") WHERE Response_No = "+ rating;
		
		Update(sql);
	}
	public static void UpdateReport(String report){
		String sql="UPDATE RESPONSE_TABLE SET Response_Report = (SELECT Response_Report + 1 FROM RESPONSE_TABLE WHERE Response_No = "+ report +") WHERE Response_No = "+ report;
		
		Update(sql);
	}
	
	public static void UpdateThreadReport(String report){
		String sql="UPDATE THREAD_TABLE SET Thread_Report = (SELECT Thread_Report + 1 FROM THREAD_TABLE WHERE Thread_No = "+ report +") WHERE Thread_No = "+ report;
		
		Update(sql);
	}
}


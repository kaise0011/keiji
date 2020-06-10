package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.info;

public class select {
	private static final String url = "jdbc:mysql://localhost:3306/javakadai?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "Ttntennis1123";

	public static ArrayList<info> searchDao(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url,user,pw);

			String sql = "SELECT * FROM keiji";

			//SQLを実行するための準備(構文解析)
			pstmt = con.prepareStatement(sql);

			//SQLを実行し、DBから結果を受領する
			rs = pstmt.executeQuery();

			//return用のArrayList生成
			ArrayList<info> list = new ArrayList<info>();

			//next()の戻り値がfalseになるまでResultSetから
			//データを取得してArrayListに追加していく
			while( rs.next() ){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String text = rs.getString("text");
				String time = rs.getString("time");
				info result = new info(id,name,mail,text,time);
				list.add(result);
			}

			//中身の詰まったArrayListを返却する
			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			//⑫DBとの切断処理
			try {
				//nullかチェックしないとNullPointerExceptionが
				//発生してしまうためチェックしている。
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}

		//途中でExceptionが発生した時はnullを返す。
		return null;
	}
}
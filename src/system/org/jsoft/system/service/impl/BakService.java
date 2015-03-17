package org.jsoft.system.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.jsoft.comm.util.HibernateSessionFactory;
import org.jsoft.comm.vo.Bak;
import org.jsoft.comm.vo.Operater;
import org.jsoft.comm.vo.PageDivid;
import org.jsoft.system.dao.IBakDAO;
import org.jsoft.system.dao.impl.BakDAO;
import org.jsoft.system.service.IBakService;

public class BakService implements IBakService {
	private IBakDAO bakDAO = new BakDAO();
	@Override
	public List<Bak> queryFistPage() {
		// TODO Auto-generated method stub
		bakDAO = new BakDAO();
		PageDivid pageDivid = new PageDivid();
		int all =  bakDAO.AllCount();
		pageDivid.setAllPage(all/pageDivid.getEachPageNum()+1);
		pageDivid.setCurrentPage(1);
		List<Bak> baks =bakDAO.queryAll(pageDivid);
		return baks;
	}

	@Override
	public List<Bak> queryNPage(int page) {
		// TODO Auto-generated method stub
		 bakDAO = new BakDAO();
		PageDivid pageDivid = new PageDivid();
		int all =  bakDAO.AllCount();
		pageDivid.setAllPage(all/pageDivid.getEachPageNum()+1);
		pageDivid.setCurrentPage(page);
		List<Bak> baks =bakDAO.queryAll(pageDivid);
		if(baks.size()==0){
			baks = null;
		}
		return baks;
	}
	/*public static void main(String[] args) {
		BakService bakService = new BakService();
		System.out.println(bakService.queryFistPage().get(0).getOperater().getOpName());
	}*/

	@Override
	public List<Bak> query(String page) {
		// TODO Auto-generated method stub
		int currentpage = 0;
		if(page!=null){
			currentpage=Integer.parseInt(page);
		}
		 List<Bak> baks=queryNPage(currentpage);
		return baks;
	}

	@Override
	public PageDivid getPageDivide(String page) {
		// TODO Auto-generated method stub
		 bakDAO = new BakDAO();
		PageDivid pageDivid = new PageDivid();
		int all =  bakDAO.AllCount();
		pageDivid.setNum(all);
		pageDivid.setAllPage((all-1)/pageDivid.getEachPageNum()+1);
		int currentpage = 1;
		System.err.println(page);
		if(page!=null&&page!=""&&!("null".equals(page))){
			System.err.println(page);
			currentpage=Integer.parseInt(page);
		}
		pageDivid.setCurrentPage(currentpage);
		return pageDivid;
	}

	@Override
	public List<Bak> queryNPage(PageDivid pageDivid) {
		// TODO Auto-generated method stub
		 bakDAO = new BakDAO();
		List<Bak> baks =bakDAO.queryAll(pageDivid);
		if(baks.size()==0){
			baks = null;
		}
		return baks;
	}

	@Override
	public void bak(String path,String fileName) {
		// TODO Auto-generated method stub
		
		try {
			Properties properties = new Properties();
			InputStream inStream = BakService.class.getClassLoader().getResourceAsStream("bak.properties");
			properties.load(inStream);
			String mysqlpath = properties.getProperty("mysqlpath");
			String db = properties.getProperty("db");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String savepath = properties.getProperty("savepath");
			String dbname = properties.getProperty("dbname");
			//"cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysqldump\" -h localhost -uroot -p123456  personnel > d:\\mysql.sql";
			
			String cmd = "cmd.exe /c \""+mysqlpath+"\\bin\\mysqldump\" -h "+db+" -u"+user+" -p"+password+" "+dbname+" > "+path+savepath+"\\"+fileName;
			String cmd2 = "cmd.exe /c dir";
			System.out.println(cmd);
			Runtime runtime = Runtime.getRuntime();
			
			Process process =runtime.exec(cmd);  
			InputStreamReader isr = new InputStreamReader(process.getInputStream());  
            LineNumberReader input = new LineNumberReader(isr);  
            String line;  
            while((line = input.readLine())!= null){  
                System.out.println(line+"~~~~~~~~~~");  
            }  
            
            InputStreamReader isr2 = new InputStreamReader(process.getErrorStream());  
            LineNumberReader input2 = new LineNumberReader(isr2);  
            String line2;  
            while((line2 = input2.readLine())!= null){  
                System.out.println(line2+"~~~~~~~~~~");  
            }  
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void rename(String path,String fileName,String oldName) {
		// TODO Auto-generated method stub
		
		try {
			Properties properties = new Properties();
			InputStream inStream = BakService.class.getClassLoader().getResourceAsStream("bak.properties");
			properties.load(inStream);
			String mysqlpath = properties.getProperty("mysqlpath");
			String db = properties.getProperty("db");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String savepath = properties.getProperty("savepath");
			String dbname = properties.getProperty("dbname");
			//"cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysqldump\" -h localhost -uroot -p123456  personnel > d:\\mysql.sql";
			
			String cmd = "cmd.exe /c rename "+path+savepath+"\\"+oldName+" "+fileName;
			System.out.println(cmd);
			Runtime runtime = Runtime.getRuntime();
			
			Process process =runtime.exec(cmd);  
			InputStreamReader isr = new InputStreamReader(process.getInputStream());  
            LineNumberReader input = new LineNumberReader(isr);  
            String line;  
            while((line = input.readLine())!= null){  
                System.out.println(line+"~~~~~~~~~~");  
            }  
      
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void restore(String path,String fileName) {
		// TODO Auto-generated method stub
		try {
			Properties properties = new Properties();
			InputStream inStream = BakService.class.getClassLoader().getResourceAsStream("bak.properties");
			properties.load(inStream);
			String mysqlpath = properties.getProperty("mysqlpath");
			String db = properties.getProperty("db");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String savepath = properties.getProperty("savepath");
			String dbname = properties.getProperty("dbname");
			//"cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysqldump\" -h localhost -uroot -p123456  personnel > d:\\mysql.sql";
			
			String cmd = "cmd.exe /c \""+mysqlpath+"\\bin\\mysql\" -h "+db+" -u"+user+" -p"+password+" "+dbname+" < "+path+savepath+"\\"+fileName;
			System.out.println(cmd);
			Runtime runtime = Runtime.getRuntime();
			Process process =runtime.exec(cmd);  
			/*InputStreamReader isr = new InputStreamReader(process.getInputStream());  
            LineNumberReader input = new LineNumberReader(isr);  
            String line;  
            while((line = input.readLine())!= null){  
                System.out.println(line+"~~~~~~~~~~");  
            }  
            
            InputStreamReader isr2 = new InputStreamReader(process.getErrorStream());  
            LineNumberReader input2 = new LineNumberReader(isr2);  
            String line2;  
            while((line2 = input2.readLine())!= null){  
                System.out.println(line2+"~~~~~~~~~~");  
            }  */
			//HibernateSessionFactory.rebuildSessionFactory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void add(Bak bak,Operater operater) {
		// TODO Auto-generated method stub
		bak.setOperater(operater);
		bakDAO.add(bak);
	}
	
	
	
	

	@Override
	public void add(String bakRemark, String fileName, Operater operater) {
		Bak bak = new Bak();
		Timestamp ts = new Timestamp(new Date().getTime());
		bak.setBakDate(ts);
		bak.setBakRemark(bakRemark);
		bak.setPath(fileName);
		bak.setOperater(operater);
		bakDAO.add(bak);
	}
	

	@Override
	public void updateBak(String bakId, Operater operater, String remark,
			Timestamp date, String path) {
		Bak bak = new Bak();
		bak = bakDAO.get(Bak.class, bakId);
		bak.setOperater(operater);
		bak.setBakDate(date);
		bak.setBakRemark(remark);
		bak.setPath(path);
		bakDAO.update(bak);
	}
	
	

	@Override
	public String deleteLie(String bakId,String username) {
		// TODO Auto-generated method stub
		String result = "no";
		Bak bak = new Bak();
		bak = bakDAO.get(Bak.class, bakId);
		if(username!=null){
			if(bak.getOperater()!=null){
				if(username.equals(bak.getOperater().getOpName())){
					bak.setIsDelete(1);
					bakDAO.update(bak);
					result="yes";
				}
			}
		}
		return result;
	}

	@Override
	public void deleteBak(String bakId) {
		// TODO Auto-generated method stub
		Bak bak = new Bak();
		bak = bakDAO.get(Bak.class, bakId);
		bakDAO.delete(bak);
	}

	@Override
	public void bakAndAdd(String path,String remark, String fileName, Operater operater) {
		// TODO Auto-generated method stub
		bak(path,fileName);
		add(remark, fileName, operater);
	}

	@Override
	public List<Bak> queryByElements(String operaterName, String upDAte,
			String DownDate,PageDivid pageDivid) {
		String last = " 00:00:00";
		Timestamp upDate=null;
		Timestamp downDate=null;
		if(operaterName==""){
			operaterName=null;
		}
		if(upDAte!=""&&upDAte!=null){
			upDAte=upDAte+last;
			 upDate =Timestamp.valueOf(upDAte);
		}
		if(DownDate!=""&&DownDate!=null){
			DownDate=DownDate+last;
			 downDate =Timestamp.valueOf(DownDate);
		}
		
		
		List<Bak> baks =bakDAO.getBakByParaments(operaterName, upDate, downDate, pageDivid);
		return baks;
	}

	@Override
	public Bak getBakById(String bakId) {
		Bak bak=bakDAO.get(Bak.class,bakId);
		return bak;
	}

	@Override
	public void editBakById(String bakId,String path,String bakRemark,String fileName) {
		Bak bak=bakDAO.get(Bak.class,bakId);
		try {
			rename(path, fileName, bak.getPath());
			bak.setBakRemark(bakRemark);
			bak.setPath(fileName);
			bakDAO.update(bak);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void delLieSome(String[] checkbox, String username) {
		for (int i = 0; i < checkbox.length; i++) {
			deleteLie(checkbox[i], username);
		}
		
	}

	/*@Override
	public void reStart() {
		try {
			Properties properties = new Properties();
			InputStream inStream = BakService.class.getClassLoader().getResourceAsStream("bak.properties");
			properties.load(inStream);
			String serverPath=properties.getProperty("serverPath");
			
			//"cmd.exe /c \"C:\\Program Files (x86)\\MySQL\\MySQL Server 5.0\\bin\\mysqldump\" -h localhost -uroot -p123456  personnel > d:\\mysql.sql";
			
			String cmd = "cmd.exe /c startup";
			System.out.println(cmd);
			Runtime runtime = Runtime.getRuntime();
			Process process =runtime.exec(cmd);  
			InputStreamReader isr = new InputStreamReader(process.getInputStream());  
            LineNumberReader input = new LineNumberReader(isr);  
            String line;  
            while((line = input.readLine())!= null){  
                System.out.println(line+"~~~~~~~~~~");  
            }  
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
/*
	public static void main(String[] args) {
		BakService bakService = new BakService();
		//bakService.bak("G:\\ecplise\\project2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\personnel\\","licheng.sql" );
		//bakService.restore("G:\\ecplise\\project2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\personnel\\", "init.sql");
		//bakService.rename("G:\\ecplise\\project2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\personnel\\", "lilili.sql", "cheng.sql");
		bakService.reStart();
	}*/
}

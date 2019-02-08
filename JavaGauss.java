import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class JavaGauss
{

	public static void main(String[] args)
	{
		// TODO 自动生成的方法存根
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				ShowFrame showFrame=new ShowFrame();
				showFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				showFrame.setTitle("高斯投影正反算");
				showFrame.setVisible(true);
			}
		}
		);
	}

}

//框架类
class ShowFrame extends JFrame{
	private static final int WIDTH=900;
	private static final int HEIGHT=600;
	public ShowFrame(){
		//设置大小
		setSize(WIDTH,HEIGHT);
		
		//设置其出现的位置，即把它显示在屏幕正中间
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		setLocation(screenSize.width/2-WIDTH/2,screenSize.height/2-HEIGHT/2);
		add(new ShowPanel());
	}
}

//面板类
class ShowPanel extends JPanel{
	private Button button1;	//54按钮
	private Button button2;	//80按钮
        private Button button3; //WGS-84按钮
        private Button button4; //CGCS2000按钮
        private Button button5; //反算按钮
       
        private Button button7; //退出按钮
	private JTextField textField1;  //B度
	private JTextField textField2;  //B分
        private JTextField textField3;  //B秒
        private JTextField textField4;  //L度
        private JTextField textField5;  //L分
        private JTextField textField6;  //L秒
        private JTextField textField7;  //x
        private JTextField textField8;  //y
       	private JLabel label1;
	private JLabel label2;
        private JLabel label3;

        private JLabel label4;
	public ShowPanel(){
		//设置为绝对布局
		this.setLayout(null);
		//设置面板颜色
		this.setBackground(Color.WHITE);
		
		//初始化控件
		button1=new Button("54");
                button2=new Button("80");		
		button3=new Button("WGS-84");
                button4=new Button("CGCS2000");
                button5=new Button("反算");
                
                button7=new Button("退出");
		textField1=new JTextField();
		textField2=new JTextField();
                textField3=new JTextField();
                textField4=new JTextField();
                textField5=new JTextField();
                textField6=new JTextField();
                textField7=new JTextField();
                textField8=new JTextField();
		label1=new JLabel("B:");
		label2=new JLabel("L:");
                label3=new JLabel("x");
                label4=new JLabel("y");  
		
		//将控件添加到面板上
		add(button1);	
                add(button2);
		add(button3);
                add(button4);
                add(button5);
                
                add(button7);
		add(textField1);
		add(textField2);
                add(textField3);
                add(textField4);
                add(textField5);
                add(textField6);
                add(textField7);
                add(textField8);
		add(label1);
		add(label2);
                add(label3);
                add(label4);
		
		//设置控件的位置
		button1.setBounds(450, 10, 60, 50);
                button2.setBounds(450,60,60,50);
		button3.setBounds(450,110,60,50);
                button4.setBounds(450,160,60,50);
                button5.setBounds(450,210,60,50);
                
                button7.setBounds(650,310,60,50);
		textField1.setBounds(80, 100, 60, 40);
		textField2.setBounds(200, 100, 60, 40);
                textField3.setBounds(320, 100, 60, 40);
                textField4.setBounds(80, 200, 60, 40);
                textField5.setBounds(200, 200, 60, 40);
                textField6.setBounds(320, 200, 60, 40);
                textField7.setBounds(100, 300, 200, 40);
                textField8.setBounds(300, 300,200, 40);
		label1.setBounds(20,100,50,40);
		label2.setBounds(20,200,50,40);
                label3.setBounds(100,400,50,40);
                label4.setBounds(300,400,50,40);
		
		//添加按钮的监听器
		button1.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				if(textField1.getText()!=null && textField2.getText()!=null && textField3.getText()!=null && textField4.getText()!=null && textField5.getText()!=null && textField6.getText()!=null){
                                        double N,a,w,B,L,b,n,e1,e2,t,p,X,x,y,b1,b2,b3,l1,l2,l3,a0,a2,a4,a6,m0,m2,m4,m6,m8,Bh,Lh,iPI,ll;
                                        iPI =Math.PI/180;
					a=6378245;
                                        p=206264.8065;
                                        b=a-(a*1/298.3);
					e1=Math.sqrt(a*a-b*b)/a;
					e2=Math.sqrt(a*a-b*b)/b;
                                        b1=Double.valueOf(textField1.getText());
                                        b2=Double.valueOf(textField2.getText());
                                        b3=Double.valueOf(textField3.getText());
                                        l1=Double.valueOf(textField4.getText());
                                        l2=Double.valueOf(textField5.getText());
                                        l3=Double.valueOf(textField6.getText());
                                        B=Double.valueOf(b1+b2/60+b3/3600);
                                        Bh=B*iPI;
                                        L=Double.valueOf(l1+l2/60+l3/3600);
                                        
                                        ll=(L-111)*3600;
                                        w=Math.sqrt(1-e1*e1*Math.sin(Bh)*Math.sin(Bh));
                                        N=a/w;
                                        n=e2*Math.cos(Bh);
                                        t=Math.tan(Bh);
                                        m0=a*(1-e1*e1);
                                        m2=3*e1*e1*m0/2;
                                        m4=5*e1*e1*m2/4;
                                        m6=7*e1*e1*m4/6;
                                        m8=9*e1*e1*m6/8;
                                        a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
                                        a2=m2/2+m4/2+15*m6/32+7*m8/16;
                                        a4=m4/8+3*m6/16+7*m8/32;
                                        a6=m6/32+m8/16;
                                        X=a0*Bh-a2*Math.sin(2*Bh)/2+a4*Math.sin(4*Bh)/4-a6*Math.sin(6*Bh);
					//避免输入字母而导致转换异常
					try{
						x=X+N*Math.sin(Bh)*Math.cos(Bh)*ll*ll/2/p/p+N*Math.sin(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*(5-t*t+9*n*n)/24/p/p/p/p;
                                                y=N*Math.cos(Bh)*ll/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*(1-t*t+n*n)/6/p/p/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*ll*(5-18*t*t+t*t*t*t)/120/p/p/p/p/p;
					}catch(NumberFormatException exce){
						//exce.printStackTrace();
						return;
					}
					
					//保留四位小数
					String value1=String.format("%.4f",x);
                                        String value2=String.format("%.4f",y);
					textField7.setText(value1);
                                        textField8.setText(value2);
                                        
                                        
					
				}
					
			}
			
		});

 
	

		button2.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				if(textField1.getText()!=null && textField2.getText()!=null && textField3.getText()!=null && textField4.getText()!=null && textField5.getText()!=null && textField6.getText()!=null){
                                        double N,a,w,B,L,b,n,e1,e2,t,p,X,x,y,b1,b2,b3,l1,l2,l3,a0,a2,a4,a6,m0,m2,m4,m6,m8,Bh,Lh,iPI,ll;
                                        iPI =Math.PI/180;
					a=6378140;
                                        p=206264.8065;
                                        b=a-(a*1/298.257);
					e1=Math.sqrt(a*a-b*b)/a;
					e2=Math.sqrt(a*a-b*b)/b;
                                        b1=Double.valueOf(textField1.getText());
                                        b2=Double.valueOf(textField2.getText());
                                        b3=Double.valueOf(textField3.getText());
                                        l1=Double.valueOf(textField4.getText());
                                        l2=Double.valueOf(textField5.getText());
                                        l3=Double.valueOf(textField6.getText());
                                        B=Double.valueOf(b1+b2/60+b3/3600);
                                        Bh=B*iPI;
                                        L=Double.valueOf(l1+l2/60+l3/3600);
                                       
                                        ll=(L-111)*3600;
                                        w=Math.sqrt(1-e1*e1*Math.sin(Bh)*Math.sin(Bh));
                                        N=a/w;
                                        n=e2*Math.cos(Bh);
                                        t=Math.tan(Bh);
                                        m0=a*(1-e1*e1);
                                        m2=3*e1*e1*m0/2;
                                        m4=5*e1*e1*m2/4;
                                        m6=7*e1*e1*m4/6;
                                        m8=9*e1*e1*m6/8;
                                        a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
                                        a2=m2/2+m4/2+15*m6/32+7*m8/16;
                                        a4=m4/8+3*m6/16+7*m8/32;
                                        a6=m6/32+m8/16;
                                        X=a0*Bh-a2*Math.sin(2*Bh)/2+a4*Math.sin(4*Bh)/4-a6*Math.sin(6*Bh);
					//避免输入字母而导致转换异常
					try{
						x=X+N*Math.sin(Bh)*Math.cos(Bh)*ll*ll/2/p/p+N*Math.sin(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*(5-t*t+9*n*n)/24/p/p/p/p;
                                                y=N*Math.cos(Bh)*ll/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*(1-t*t+n*n)/6/p/p/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*ll*(5-18*t*t+t*t*t*t)/120/p/p/p/p/p;
					}catch(NumberFormatException exce){
						//exce.printStackTrace();
						return;
					}
					
					//保留四位小数
					String value1=String.format("%.4f",x);
                                        String value2=String.format("%.4f",y);
					textField7.setText(value1);
                                        textField8.setText(value2);
                                        
                                        
					
				}
			}
			
		});
		
	        button3.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				if(textField1.getText()!=null && textField2.getText()!=null && textField3.getText()!=null && textField4.getText()!=null && textField5.getText()!=null && textField6.getText()!=null){
                                        double N,a,w,B,L,b,n,e1,e2,t,p,X,x,y,b1,b2,b3,l1,l2,l3,a0,a2,a4,a6,m0,m2,m4,m6,m8,Bh,Lh,iPI,ll;
                                        iPI =Math.PI/180;
					a=6378137;
                                        p=206264.8065;
                                        b=a-(a*1/298.257223563);
					e1=Math.sqrt(a*a-b*b)/a;
					e2=Math.sqrt(a*a-b*b)/b;
                                        b1=Double.valueOf(textField1.getText());
                                        b2=Double.valueOf(textField2.getText());
                                        b3=Double.valueOf(textField3.getText());
                                        l1=Double.valueOf(textField4.getText());
                                        l2=Double.valueOf(textField5.getText());
                                        l3=Double.valueOf(textField6.getText());
                                        B=Double.valueOf(b1+b2/60+b3/3600);
                                        Bh=B*iPI;
                                        L=Double.valueOf(l1+l2/60+l3/3600);
                                        
                                        ll=(L-111)*3600;
                                        w=Math.sqrt(1-e1*e1*Math.sin(Bh)*Math.sin(Bh));
                                        N=a/w;
                                        n=e2*Math.cos(Bh);
                                        t=Math.tan(Bh);
                                        m0=a*(1-e1*e1);
                                        m2=3*e1*e1*m0/2;
                                        m4=5*e1*e1*m2/4;
                                        m6=7*e1*e1*m4/6;
                                        m8=9*e1*e1*m6/8;
                                        a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
                                        a2=m2/2+m4/2+15*m6/32+7*m8/16;
                                        a4=m4/8+3*m6/16+7*m8/32;
                                        a6=m6/32+m8/16;
                                        X=a0*Bh-a2*Math.sin(2*Bh)/2+a4*Math.sin(4*Bh)/4-a6*Math.sin(6*Bh);
					//避免输入字母而导致转换异常
					try{
						x=X+N*Math.sin(Bh)*Math.cos(Bh)*ll*ll/2/p/p+N*Math.sin(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*(5-t*t+9*n*n)/24/p/p/p/p;
                                                y=N*Math.cos(Bh)*ll/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*(1-t*t+n*n)/6/p/p/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*ll*(5-18*t*t+t*t*t*t)/120/p/p/p/p/p;
					}catch(NumberFormatException exce){
						//exce.printStackTrace();
						return;
					}
					
					//保留四位小数
					String value1=String.format("%.4f",x);
                                        String value2=String.format("%.4f",y);
					textField7.setText(value1);
                                        textField8.setText(value2);
                                        
                                        
					
				}
			}
			
		});
		
		
		button4.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				if(textField1.getText()!=null && textField2.getText()!=null && textField3.getText()!=null && textField4.getText()!=null && textField5.getText()!=null && textField6.getText()!=null){
                                        double N,a,w,B,L,b,n,e1,e2,t,p,X,x,y,b1,b2,b3,l1,l2,l3,a0,a2,a4,a6,m0,m2,m4,m6,m8,Bh,Lh,iPI,ll;
                                        iPI =Math.PI/180;
					a=6378137;
                                        p=206264.8065;
                                        b=a-(a*1/298.257222101);
					e1=Math.sqrt(a*a-b*b)/a;
					e2=Math.sqrt(a*a-b*b)/b;
                                        b1=Double.valueOf(textField1.getText());
                                        b2=Double.valueOf(textField2.getText());
                                        b3=Double.valueOf(textField3.getText());
                                        l1=Double.valueOf(textField4.getText());
                                        l2=Double.valueOf(textField5.getText());
                                        l3=Double.valueOf(textField6.getText());
                                        B=Double.valueOf(b1+b2/60+b3/3600);
                                        Bh=B*iPI;
                                        L=Double.valueOf(l1+l2/60+l3/3600);
                                       
                                        ll=(L-111)*3600;
                                        w=Math.sqrt(1-e1*e1*Math.sin(Bh)*Math.sin(Bh));
                                        N=a/w;
                                        n=e2*Math.cos(Bh);
                                        t=Math.tan(Bh);
                                        m0=a*(1-e1*e1);
                                        m2=3*e1*e1*m0/2;
                                        m4=5*e1*e1*m2/4;
                                        m6=7*e1*e1*m4/6;
                                        m8=9*e1*e1*m6/8;
                                        a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
                                        a2=m2/2+m4/2+15*m6/32+7*m8/16;
                                        a4=m4/8+3*m6/16+7*m8/32;
                                        a6=m6/32+m8/16;
                                        X=a0*Bh-a2*Math.sin(2*Bh)/2+a4*Math.sin(4*Bh)/4-a6*Math.sin(6*Bh);
					//避免输入字母而导致转换异常
					try{
						x=X+N*Math.sin(Bh)*Math.cos(Bh)*ll*ll/2/p/p+N*Math.sin(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*(5-t*t+9*n*n)/24/p/p/p/p;
                                                y=N*Math.cos(Bh)*ll/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*(1-t*t+n*n)/6/p/p/p+N*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*Math.cos(Bh)*ll*ll*ll*ll*ll*(5-18*t*t+t*t*t*t)/120/p/p/p/p/p;
					}catch(NumberFormatException exce){
						//exce.printStackTrace();
						return;
					}
					
					//保留四位小数
					String value1=String.format("%.4f",x);
                                        String value2=String.format("%.4f",y);
					textField7.setText(value1);
                                        textField8.setText(value2);
                                        
                                        
					
				}
			}
			
		});
		

		button5.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				double x=Double.valueOf(textField7.getText());
                                double y=Double.valueOf(textField8.getText());
                                double a=6378137;
                                double p=206264.8065;
                                double b=a-(a*1/298.257222101);
				double e1=Math.sqrt(a*a-b*b)/a,e2=Math.sqrt(a*a-b*b)/b;
                                double iPI=Math.PI/180;
                                double f=1.0 / 298.26;
                                double[] output = new double[2];
                                double b1,b2,b3,B,Bh,m0,m2,m4,m6,m8,a0,a2,a4,a6,X;
                                b1=Double.valueOf(textField1.getText());
                                b2=Double.valueOf(textField2.getText());
                                b3=Double.valueOf(textField3.getText());
                                B=Double.valueOf(b1+b2/60+b3/3600);
                                Bh=B*iPI;
                                m0=a*(1-e1*e1);
                                m2=3*e1*e1*m0/2;
                                m4=5*e1*e1*m2/4;
                                m6=7*e1*e1*m4/6;
                                m8=9*e1*e1*m6/8;
                                a0=m0+m2/2+3*m4/8+5*m6/16+35*m8/128;
                                a2=m2/2+m4/2+15*m6/32+7*m8/16;
                                a4=m4/8+3*m6/16+7*m8/32;
                                a6=m6/32+m8/16;
                                X=a0*Bh-a2*Math.sin(2*Bh)/2+a4*Math.sin(4*Bh)/4-a6*Math.sin(6*Bh); 
                                double bb=X/6367588.4969;
                                double Bf=bb+(50221746+(293622+(2350+22*Math.cos(bb)*Math.cos(bb))*Math.cos(bb)*Math.cos(bb))*Math.cos(bb)*Math.cos(bb))*0.0000000001*Math.sin(bb)*Math.cos(bb);
                                double tf=Math.tan(Bf);
                                double wf=Math.sqrt(1-e1*e1*Math.sin(Bf)*Math.sin(Bf));
                                double Mf=a*(1-e1*e1)/wf/wf/wf;
                                double Nf=a/wf;
                                double nf=e2*Math.cos(Bf);
                                
                                double latitude=Bf-tf*y*y/2/Mf/Nf+tf*y*y*y*y*(5+3*tf*tf+nf*nf-9*nf*nf*tf*tf)/24/Mf/Nf/Nf/Nf-tf*(61+90*tf*tf+45*tf*tf*tf*tf)*y*y*y*y*y*y/720/Mf/Nf/Nf/Nf/Nf/Nf;
                                double longitude=y/Nf/Math.cos(Bf)-y*y*y*(1+2*tf*tf+nf*nf)/6/Nf/Nf/Nf/Math.cos(Bf)+y*y*y*y*y*(5+28*tf*tf+24*tf*tf*tf*tf+6*nf*nf+8*nf*nf*tf*tf)/120/Nf/Nf/Nf/Nf/Nf/Math.cos(Bf);
	                        //转换为度 DD  
	                        output[0] = latitude / iPI;   
	                        output[1] = longitude / iPI+111;
                                int B1=(int)output[0];
                                int B2=(int)((output[0]-b1)*60);
                                double B3=(output[0]-b1-b2/60)*3600;
                                int l1=(int)output[1];
                                int l2=(int)((output[1]-l1)*60);
                                double l3=output[1]*3600-l1*3600-l2*60;
                                String value1=String.format("%d",B1);
                                String value2=String.format("%d",B2);
                                String value3=String.format("%.4f",B3);
                                String value4=String.format("%d",l1);
                                String value5=String.format("%d",l2);
                                String value6=String.format("%.4f",l3);
			        textField1.setText(value1);
                                textField2.setText(value2);
                                textField3.setText(value3);
                                textField4.setText(value4);
                                textField5.setText(value5);
                                textField6.setText(value6);
                                        
			}
			
		});
		

		button7.addActionListener(new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO 自动生成的方法存根
				System.exit(0);
			}
			
		});
		
		
	}
	
}

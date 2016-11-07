package adwords.campaign.creation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class DisplayEditCampDAO {

//Returns List of Display Campaign Data
	
	public static ChannelCampaign getCampaignChanneldata(String campaignId,String channelId){
		
		   String ServerConnectionURL = "jdbc:mysql://52.90.244.81:3306/cuberootapp";
			
		    
		    String DBUser = "root";
		    String DBPass = "Qwerty12@";
		    String DBName = "cuberootapp";
			String TABLENAME = "";
			Connection con = null;
			Connection con1 = null;
			Connection con2 = null;
			Connection con3 = null;
			DBConnector connector = new DBConnector();
			con = connector.getPooledConnection(ServerConnectionURL);
		    String status1 = "false";
		    Statement stmt = null;
		    String targettype = null;
		    String lookalike = null;
		    String campName = null;
		    String startDate= null;
	        String endDate = null;
		    String status = null;
		    String title = null;
		    String impressions = null;
		    String clicks = null;
		    String conversions = null;
		    String cost = null;
		    String channel = null;
		    Integer size = 0;
	        String date = null;
	        String id = null;
	//        List<DisplayCampaign> campaign = new ArrayList<DisplayCampaign>();
		    String query1 =null;
		    String query2 =null;
		    String query3 =null;
		    String query4 =null;
		    String query5 = null;
		    String query6 = null;
		    String query7 = null;
		    String query8 = null;
		    String query9= null;
		    String query10= null;
		    String query11=null;
		    String query12 = null;
		    String query13=null;
		    String query14 = null;
		    String query15 = null;
		    String query16 = null;
		    String query17 = null;
			String queryPerformanceData;
			String queryPerformanceDatachannelwise;
			String queryChannelSpecificData;
		    Statement st = null;
		    Statement st1 = null;
		    Statement st2 = null;
		    Statement st3 = null;
		    ResultSet rs = null;
		    String targetcampaignchannelid = null;
		    String budgetcampaignchannelid  = null;
		    ResultSet rs1 = null;
		    ResultSet rs2 = null;
		    ResultSet rs3 = null;
		    ResultSet rs4 = null;
		    ResultSet rs5 = null;
		    ResultSet rs6 = null;
		    ResultSet rs7 = null;
		    ResultSet rs8 = null;
		    ResultSet rs9 = null;
		    ResultSet rs10= null;
		    ResultSet rs11 = null;
		    ResultSet rs12 = null;
		    ResultSet rs14 = null;
		    ResultSet rs15 = null;
		    String interestsegmentid = null;
		    String [] interestsegmentparts;
		    String [] interestsegmentparts1;
		    String geographyid = null;
		    String agerange = null;
		    String gender = null;
		    String startdate = null;
		    String enddate = null;
		    String incomelevel = null;
		    String idealtarget = null;
		    List<Device> DeviceId = new ArrayList<Device>();
		    List<Geography> geography = new ArrayList<Geography>();
		    List<OperatingSystem> os = new ArrayList<OperatingSystem>();
		    List<AgeGroup> agegroup = new ArrayList<AgeGroup>();
		    List<Income> inc = new ArrayList<Income>();
		    List<Gender> Gender = new ArrayList<Gender>();
 		    List<AudienceSegment> segment = new ArrayList<AudienceSegment>();
 		    List<Resolution> resolution = new ArrayList<Resolution>();
 		    ChannelCampaign campchanneldata=  new ChannelCampaign();
 		    List<Creative> creativelist = new ArrayList<Creative>();
 		    
	        query1  = "Select Id,StartDate,EndDate,BudgetCampaignChannelId,TargetCampaignChannelId From CampaignChannel Where CampaignId="+campaignId+" And ChannelId="+channelId;
	    
	    //Make a list of Device object,Segment Object,Operating System Id,IncomeId,GeographyId
	    //Generate a List of Device object, Segment Object, Operating system, Income Object, Geography Object Corresponding to campaign, This targeting information will be passed to the from for display.
	    //Separate Controller for submitting edit form data, it will call Update Queries will get Campaign DTO from jackson core and will populate it in Database. Same holds for budget campaign Data.
	       
	        
	        try {
				stmt = con.createStatement();
			
	        
	         try {
				rs = stmt.executeQuery(query1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    
	        try {
				if(rs.next()){
					
				  targetcampaignchannelid = rs.getString("TargetCampaignChannelId"); 	
				  
				  budgetcampaignchannelid  = rs.getString("BudgetCampaignChannelId");
					
				  startdate = rs.getString("StartDate");
						  
				  enddate = rs.getString("EndDate");
				
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	         
	         
	         
	         query2 = "Select * from TargetCampaign where Id='"+targetcampaignchannelid+"'";
	         try {
				st = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				rs3=  st.executeQuery(query2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 try {
				while(rs3.next()){
				
				 interestsegmentid = rs3.getString("InterestSegmentId");
				 interestsegmentparts = interestsegmentid.split(",");
				 interestsegmentid = "";

				 for(int i=0; i<interestsegmentparts.length; i++)
				 {
					interestsegmentparts1 = interestsegmentparts[i].split(":");
					if(i==0)
					interestsegmentid = interestsegmentid + interestsegmentparts1[1];
					else
					interestsegmentid = interestsegmentid +","+ interestsegmentparts1[1];	
				 }
			//	 interestsegmentid = interestsegmentid.substring(0,interestsegmentid.length()-1);
				 
						 
				 geographyid = rs3.getString("GeographyId");
				 geographyid = geographyid.substring(0,geographyid.length()-1);
				 
				 agerange = rs3.getString("AgeRange");
				 agerange = agerange.substring(0, agerange.length()-1);
				 
				 gender = rs3.getString("Gender");
				 gender = gender.substring(0,gender.length()-1);
				
				 incomelevel = rs3.getString("IncomeRange");
			//	 if(incomelevel.length() >=2)
			//	 incomelevel = incomelevel.substring(0, incomelevel.length()-2);
				 
				 targettype = rs3.getString("TargetType");
				 
				 idealtarget = rs3.getString("IdealTarget");
				 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //	    query = "Update CampaignChannel Set Status = '"+status+"'"+" WHERE Id="+id+ " AND Channel ='"+channel+"'"+"AND EmailId="+"'"+emailid+"'";
	    	
	      
			 query6 =  "Select * from Geography where Id in ("+geographyid+")";
			 
			 try {
				rs1=  st.executeQuery(query6);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
					try {
						while(rs1.next()){
						Geography geo = new Geography();
						geo.setId(rs1.getString("Id"));
						geo.setCity(rs1.getString("City"));
						geography.add(geo);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
			 
			query17 = "Select * from IncomeRange where Id in ("+incomelevel+")";	
					
			 try {
					rs14=  st.executeQuery(query17);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
						try {
							while(rs14.next()){
							Income inc1 = new Income();
							inc1.setId(rs14.getString("Id"));
							inc1.setName(rs14.getString("Name"));
							inc.add(inc1);
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
					
					
			 
			 query7 =  "Select * from AgeGroup where Id in ("+agerange+")";
			 
			 try {
				rs2=  st.executeQuery(query7);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 
					try {
						while(rs2.next()){
							AgeGroup range = new AgeGroup();
							range.setId(rs2.getString("Id"));
						    range.setAgeGroup(rs2.getString("AgeGroup"));
							agegroup.add(range);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			 
			 query8 =  "Select * from Gender where Id in ("+gender+")";	 
			
			 try {
				rs3=  st.executeQuery(query8);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			         try {
						while(rs3.next()){
						Gender gen = new Gender();
						gen.setId(rs3.getString("Id"));
						gen.setGenderType(rs3.getString("Gender"));
						Gender.add(gen);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 
			
		     query9 = "Select * from category where Id in ("+interestsegmentid+")";	 
             
		     
		    try {
				rs4=  st.executeQuery(query9);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		     
					try {
						while(rs4.next()){
						  AudienceSegment seg  = new AudienceSegment();
						  seg.setId(rs4.getString("id"));
						  seg.setParent_id(rs4.getString("parent_id"));;
						  seg.setAudienceSegmentName(rs4.getString("category"));
						  segment.add(seg);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		     
		 
             
			 query3 = "Select DeviceId FROM TargetCampaignDevice WHERE TargetCampaignId="+targetcampaignchannelid;
	        
			 try {
				rs5=  st.executeQuery(query3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
			 String deviceId = null; 
			 
			 try {
				if(rs5.next())
				 {
					 
					deviceId = rs5.getString("DeviceId"); 
					deviceId = deviceId.substring(0,deviceId.length()-1);
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 query11=  "Select * from Device WHERE Id in ("+deviceId+")";
			 
			 try {
					rs6=  st.executeQuery(query11);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 
			 
					try {
						while(rs6.next()){
						   Device obj = new Device();
						   obj.setId(rs6.getString("Id"));
						   obj.setDeviceName(rs6.getString("Name"));
						   DeviceId.add(obj);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	       


             query4  = "Select OperatingSystemId FROM TargetCampaignOS WHERE TargetCampaignId="+targetcampaignchannelid;
	        
             try {
				rs7=  st.executeQuery(query4);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
           String operatingsystemId = null; 
			 
			 try {
				if(rs7.next())
				 {
					 
					operatingsystemId = rs7.getString("OperatingSystemId"); 
					operatingsystemId = operatingsystemId.substring(0,operatingsystemId.length()-1);
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 query11=  "Select * from OperatingSystems where Id in ("+operatingsystemId+")";
			 
			 try {
					rs8=  st.executeQuery(query11);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				              
             
				try {
					while(rs8.next()){
					   OperatingSystem os1 = new OperatingSystem();
					   os1.setId(rs8.getString("Id"));
					   os1.setOperatingSystemName(rs8.getString("Name"));
					   os.add(os1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             
             
	        
            query5 = "Select * FROM TargetCampaignResolution WHERE TargetCampaignId="+targetcampaignchannelid;
	        
            
            try {
				rs9=  st.executeQuery(query5);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
            String resolutionId = null; 
			 
			 try {
				if(rs9.next())
				 {
					 
					resolutionId = rs9.getString("ResolutionId"); 
					resolutionId  = resolutionId.substring(0,resolutionId.length()-1);
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
            
             query16=  "Select * from Resolution where Id in ("+resolutionId+")";
			 
			 try {
					rs12=  st.executeQuery(query16);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
            
            
				try {
					while(rs12.next()){
					   Resolution res = new Resolution();
					   res.setId(rs12.getString("Id"));
					   res.setResolution(rs12.getString("Resolution"));
					   resolution.add(res);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
				
				query10 = "Select * FROM BudgetCampaignChannel Where Id="+budgetcampaignchannelid;

				
				 try {
						rs10=  st.executeQuery(query10);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
						try {
							while(rs10.next()){
							   campchanneldata.setBudgetpercentage(rs10.getString("BudgetPercentage"));
							   campchanneldata.setChannelbudget(rs10.getString("ChannelBudget"));
							   campchanneldata.setDailycap(rs10.getString("DailyCap"));
							   campchanneldata.setExpectedbid(rs10.getString("ExpectedBid"));
							   campchanneldata.setMaxbid(rs10.getString("MaxBid"));
							   campchanneldata.setMonthlycap(rs10.getString("MonthlyCap"));
							   campchanneldata.setComments(rs10.getString("Comments"));
							   campchanneldata.setClicktracker(rs10.getString("ClickTracker"));
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				
		
						
				query15 = "Select CreativeId from CampaignChannel where CampaignId ='"+campaignId+"' And ChannelId='"+channelId+"'";		
						
				try {
					rs11=  st.executeQuery(query15);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
	           String creativeId = null; 
				 
				 try {
					if(rs11.next())
					 {
						 
						creativeId = rs11.getString("CreativeId"); 
					//	creativeId  = creativeId.substring(0,creativeId.length()-1);
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 if(channelId.equals("1"))
				 query15 =  "Select * from FacebookCreative where Id in ("+creativeId+")";
				 
				 else if(channelId.equals("2") || channelId.equals("3"))
				 query15=  "Select * from DisplayCreative where Id in ("+creativeId+")";
				 
				 else
				 query15=  "Select * from RestCreative where Id in ("+creativeId+")";
				 
				 
				
				 
				 
				 try {
						rs15=  st.executeQuery(query15);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					              
	             
					try {
						while(rs15.next()){
						   Creative creative = new Creative();
						   creative.setId(rs15.getInt("Id"));
						   creative.setTitle(rs15.getString("Title"));
						   creative.setType(rs15.getString("Type"));
						   creativelist.add(creative);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
						
                campchanneldata.setDeviceid(DeviceId);	
	            campchanneldata.setInterestsegmentid(segment);
	            campchanneldata.setOperatingsystemid(os);
	            campchanneldata.setGeographyid(geography);
	            campchanneldata.setAgerange(agegroup);
	            campchanneldata.setGender(Gender);
	            campchanneldata.setResolutionid(resolution);
	            campchanneldata.setCreative(creativelist);
	            campchanneldata.setIncomelevel(inc);
		        campchanneldata.setId(campaignId);
		        campchanneldata.setChannelid(channelId);
	     //       campchanneldata.setLookalike(lookalike);
	     //       campchanneldata.setTargettype(targettype);
		        campchanneldata.setIdealTargeting(idealtarget);
		        campchanneldata.setTargettype("manual");
	            campchanneldata.setStartdate(startdate);
	            campchanneldata.setEnddate(enddate);
	        
	        } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	            
            finally{
				
			    DBUtil.close(rs);
			    DBUtil.close(rs1);
			    DBUtil.close(rs2);
			    DBUtil.close(rs3);
			    DBUtil.close(rs);
			    DBUtil.close(rs4);
			    DBUtil.close(rs5);
			    DBUtil.close(rs6);
			    DBUtil.close(rs7);
			    DBUtil.close(rs8);
			    DBUtil.close(rs9);
			    DBUtil.close(rs10);
			    DBUtil.close(rs11);
			    DBUtil.close(rs12);
			    DBUtil.close(rs14);
			    DBUtil.close(rs15);
			    
			    DBUtil.close(stmt);
			    DBUtil.close(st1);
			    DBUtil.close(st2);
			    DBUtil.close(st3);
				
			    
			    DBUtil.close(con);
				
			}    
	            
	            
	            return campchanneldata;
	
	
	
	}
    

}

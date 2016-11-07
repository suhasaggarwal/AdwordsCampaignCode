package adwords.campaign.creation;

import java.util.ArrayList;
import java.util.List;

public class AudienceSegment {

private String Id;

private String parent_id;

private String count;

public String getCount() {
	return count;
}

public void setCount(String count) {
	this.count = count;
}

public String getParent_id() {
	return parent_id;
}

public void setParent_id(String parent_id) {
	this.parent_id = parent_id;
}

public String getId() {
	return Id;
}

public void setId(String id) {
	Id = id;
}

public String getAudienceSegmentName() {
	return AudienceSegmentName;
}

public void setAudienceSegmentName(String audienceSegmentName) {
	AudienceSegmentName = audienceSegmentName;
}

public List<AudienceSegment> getSubcategory() {
	return subcategory;
}

public void setSubcategory(List<AudienceSegment> subcategory) {
	this.subcategory = subcategory;
}

private String AudienceSegmentName;

private List<AudienceSegment> subcategory = new ArrayList<AudienceSegment>();


}

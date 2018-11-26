package ch02;

public class LLStringNode
{
	private String info;			// information stored in list
	private LLStringNode link;		// reference to a node
	
	// Constructor
	public LLStringNode(String info)
	{
		this.info = info;
		link = null;
	}
	
	public String getInfo()
	{
		return info;
	}
	
	public void setInfo(String info)
	{
		this.info = info;
	}
	
	public LLStringNode getLink()
	{
		return link;
	}
	
	public void setLink(LLStringNode link)
	{
		this.link = link;
	}
	
	
	
	
	/*
	LLStringNode letters = new LLStringNode(info);
	
	LLStringNode currNode = letters;
	while (currNode != null)
	{
		System.out.println(currNode.getInfo());
		currNode = currNode.getLink();
		newNode.setLink(letters);
		letters = newNode;
	}
	
	
	
	
	
	
	
	LLStringNode sNode1 = new LLStringNode("basketball");
	LLStringNode sNode2 = new LLStringNode("baseball");
	sNode1.setLink(sNode2);
	
	
	LLStringNode theList;	// value held in the string node variable is null (theList: null)
	
	
	
	*/
	
	
	
	
	
	
	
}

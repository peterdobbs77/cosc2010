//----------------------------------------------------------------------
// LinkedStringLog.java       by Dale/Joyce/Weems              Chapter 2
//
// Implements StringLogInterface using a linked list 
// of LLStringNode to hold the log strings.
//----------------------------------------------------------------------

package adts;

public class LinkedStringLog implements StringLogInterface 
{
  protected LLStringNode log; // reference to first node of linked 
                              // list that holds the StringLog strings
  protected String name;      // name of this StringLog
  
  public LinkedStringLog(String name)
  // Instantiates and returns a reference to an empty StringLog object 
  // with name "name".
  {
    log = null;
    this.name = name;
  }

  public void insert(String element)
  // Precondition:   This StringLog is not full.
  //
  // Places element into this StringLog.
  {      
    LLStringNode newNode = new LLStringNode(element);
    newNode.setLink(log);
    log = newNode;
  }
  
  public void insertLast(String element){
	  LLStringNode node;
	  
	  if(log==null){
		  LLStringNode newNode = new LLStringNode(element);
		  log = newNode;
	  }
	  else{
		  node = log;
		  while(node.getLink() != null){
			  node = node.getLink();
		  }
		  LLStringNode newNode = new LLStringNode(element);
		  node.setLink(newNode);
	  }
  }
  
  public void removeFirst() throws Exception{
	  if (log==null) throw new Exception("Cannot remove on an empty list");
	  LLStringNode node = log;
	  if (node.getInfo() != null){
		  LLStringNode newNode = node.getLink();
		  node.setLink(newNode);
	  }
  }
  
  // remove the first occurrence of element in the linked list. Do not take
  // an action if the element does not exist in the linked list. Throw an error
  public void remove(String element) throws Exception{
	  if (log==null) throw new Exception("Cannot remove from empty log");
	  if (!this.contains(element)) return;
	  LLStringNode node = log;
	  if (node.getInfo().equals(element)){
		  removeFirst();
		  return;
	  }
	  LLStringNode previous = node;
	  node = node.getLink();
	  while (node != null){  
		  if (node.getInfo().equals(element)){
			  LLStringNode newNode = node.getLink();
			  node = previous;
			  node.setLink(newNode);
			  return;
		  }
		  previous = node;
		  node = node.getLink();
	  }
  }

  public boolean isFull()
  // Returns true if this StringLog is full, false otherwise.
  {              
    return false;
  }
  
  public int size()
  // Returns the number of Strings in this StringLog.
  {
    int count = 0;
    LLStringNode node;
    node = log;
    while (node != null)
    {
      count++;
      node = node.getLink();
    }
    return count;
  }
  
  public boolean contains(String element)
  // Returns true if element is in this StringLog,
  // otherwise returns false.
  // Ignores case difference when doing string comparison.
  {                 
    LLStringNode node;
    node = log;

    while (node != null) 
    {
      if (element.equalsIgnoreCase(node.getInfo()))  // if they match
        return true;
      else
        node = node.getLink();
    }

   return false;
  }
  
  public void clear()
  // Makes this StringLog empty.
  { 
    log = null;
  }

  public String getName()
  // Returns the name of this StringLog.
  {
    return name;
  }
  
  public LLStringNode getLog(){
	  return log;
  }
  

  public boolean equals(Object other){
	  boolean result = false;
	  if (other instanceof LinkedStringLog){
		  LinkedStringLog otherLog = (LinkedStringLog) other;
		  if(this.size() == otherLog.size())
			  result = true;
		  for (int i=0;i<size();i++){
			  //if(this.contains(((LinkedStringLog) other).getLog()));
		  }
	  }
	  return result;
  }
  
  public String toString()
  // Returns a nicely formatted string representing this StringLog.
  {
    String logString = "Log: " + name + "\n\n";
    LLStringNode node;
    node = log;	
    int count = 0;
    
    while (node != null)
    {
      count++;
      logString = logString + count + ". " + node.getInfo() + "\n";
      node = node.getLink();
    }
      
    return logString;
  }
}

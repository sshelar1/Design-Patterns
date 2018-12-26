package studentCoursesBackup.myTree;

public interface SubjectI {
	public void registerObserver(ObserverI o);
	public void removeObserver(ObserverI o);
	public void notifyObservers(Character character);
}

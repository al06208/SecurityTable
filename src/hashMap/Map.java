package hashMap;
	public interface Map <K, V>{
		public void clear();
		
		public boolean containsKey(K key);
		
		public boolean containsValue(V value);
		
		public java.util.Set<Entry<K,V>> entrySet();
		
		public V get(K key);
		
		public boolean isEmpty ();
		
		public java.util.Set<K> KeySet();
		
		public V put(K key, V value);
		
		public void remove(K key);
		
		public int size();
		
		public java.util.Set<V> values();
		
		public static class Entry<K, V>{
			K key;
			V value;
			
			Entry(K key, V value){
				this.key = key;
				this.value = value;
			}
			public K getKey() {
				return key;
			}
			public V getValue() {
				return value;
			}
			public String toString() {
				return"[" + key + " , " + value + "]";
			}
		}
	}


package RedisClient;

import java.util.Set;

import redis.clients.jedis.*;

public class JedisUsage {
	// Setting up a pool of connections to connect to the Redis server. The pool
	// is configured to the default IP address to which the server will bind
	private JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");

	private void test() {

		Jedis jedis = null;
		try {
			// take a resource from the pool
			jedis = pool.getResource();
			// set the key-value
			jedis.set("Hello", "World");
			// get the value
			String value = jedis.get("Hello");
			System.out.println("Get: " + value);
			jedis.zadd("vehicle", 0, "car");
			jedis.zadd("vehicle", 0, "bike");
			jedis.zadd("vehicle", 1, "truck");
			Set<String> vehicles = jedis.zrange("sose", 0, -1);

			for (String s : vehicles) {
				System.out.println(s.toString());
			}

		} finally {
			// return the resource into the pool for reuse and close the pool
			if (jedis != null) {
				jedis.close();
			}
			// close all connections
			pool.destroy();
		}
	}

	public static void main(String args[]) {
		JedisUsage helloWorld = new JedisUsage();
		helloWorld.test();
	}
}
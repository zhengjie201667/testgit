package com.java.utils;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ServerUtil {
	private static final Logger logger = LogManager.getLogger();
	public static Session session ;
	public static Channel channel ;
	public static ChannelSftp channelSftp ;
	
	public static ChannelSftp getServerconnect(String host, String username, String password, int port) {
		JSch jSch = new JSch();

		try {
			session = jSch.getSession(username, host, port);
			session.setPassword(password);
			Properties properties = new Properties();
			properties.put("StrictHostKeyChecking", "no");
			session.setConfig(properties);
			session.connect();
			logger.info("session connect succsfully");
			channel = session.openChannel("sftp");
			channel.connect();
			logger.info("chanel connect succsfully");
		} catch (JSchException e) {
			e.printStackTrace();
			logger.info("server connect fail");
		}
		return (ChannelSftp) channel;
	}
	
	public static void uploadFileToServer(String src, String dst,ChannelSftp channelSftp) {
		try {
			channelSftp.put(src, dst, ChannelSftp.OVERWRITE);
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}

	public static void closeConnect() {
		channel.disconnect();
		session.disconnect();
	}
}

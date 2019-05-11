# Charta Caeli launch utility. Store and exec in WEB-INF directory.
#
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk
export PATH=$JAVA_HOME/bin:$PATH
export LD_LIBRARY_PATH=lib:$CUDA_HOME/lib64:$LD_LIBRARY_PATH
export VIEWER=gs\ -dBATCH\ -dNOPAUSE\ -q\ -
export GS_FONTPATH=`pwd`

java -classpath "classes:lib:lib/*" \
	-Djava.library.path=lib \
	-Djava.util.logging.config.file=lib/logging.properties \
	org.chartacaeli.ChartaCaeli viewer=$VIEWER $*

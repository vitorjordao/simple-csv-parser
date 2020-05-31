(ns core
  (:import java.io.File)
  (:require [parser :refer [parser]]))


(defn open-file
  "Attempts to open a file and complains if the file is not present."

  [file-name]
  (let [file-data (try
                    (slurp file-name)
                    (catch Exception e (println (.getMessage e))))]
    file-data))

(defn ret-csv-data
  "Returns a lazy sequence generated by parse-csv.
 Uses open-file which will return a nil, if
 there is an exception in opening fnam.

 parse-csv called on non-nil file, and that
 data is returned."

  [fnam]
  (let [csv-file (open-file fnam)]
    (if-not (nil? csv-file)
      (parser csv-file)
      nil)))

(defn fetch-csv-data
  "This function accepts a csv file name, and returns parsed csv data,
     or returns nil if file is not present."

  [csv-file]
  (ret-csv-data csv-file))


(defn -main
  [& args]
  (println (fetch-csv-data (first args))))